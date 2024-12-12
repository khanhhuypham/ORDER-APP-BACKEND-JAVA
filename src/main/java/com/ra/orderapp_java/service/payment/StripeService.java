package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.model.dto.payment.ChargeRequestDTO1;
import com.ra.orderapp_java.model.dto.payment.ChargeRequestDTO2;

import com.ra.orderapp_java.model.dto.payment.ProductRequestDTO;
import com.ra.orderapp_java.model.dto.payment.StripeResponse;
import com.ra.orderapp_java.util.StripeCustomerUtil;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.param.*;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;
    private Logger logger = LoggerFactory.getLogger(StripeService.class);

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }



    public String createCustomer(String email, String token) {

        String id = null;

        try {
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("description", "Charge for customer with email of " + email);
            customerParams.put("email", email);
            // obtained with stripe.js
            customerParams.put("source", token);
            Customer customer = Customer.create(customerParams);
            id = customer.getId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean cancelSubscription(String subscriptionId) {

        boolean subscriptionStatus;

        try {
            Subscription subscription = Subscription.retrieve(subscriptionId);
            subscription.cancel();
            subscriptionStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
            subscriptionStatus = false;
        }
        return subscriptionStatus;
    }


    public String createSubscription(String customerId, String plan, String coupon) {

        String subscriptionId = null;

        try {

            Map<String, Object> item = new HashMap<>();
            item.put("plan", plan);

            Map<String, Object> items = new HashMap<>();
            items.put("0", item);

            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerId);
            params.put("items", items);

            if (!coupon.isEmpty()) {
                params.put("coupon", coupon);
            }

            Subscription subscription = Subscription.create(params);

            subscriptionId = subscription.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subscriptionId;
    }



    public Coupon retriveCoupon(String code) {
        try {
            return Coupon.retrieve(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Charge charge(ChargeRequestDTO2 chargeRequestDTO2) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequestDTO2.getAmount());
        chargeParams.put("currency", chargeRequestDTO2.getCurrency());
        chargeParams.put("description", chargeRequestDTO2.getDescription());
        chargeParams.put("source", chargeRequestDTO2.getStripeToken());
        return Charge.create(chargeParams);
    }


    public StripeResponse checkout(ProductRequestDTO request) {

        Stripe.apiKey = secretKey;

        SessionCreateParams.Builder paramsBuilder = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("http://localhost:8080/success")
            .setCancelUrl("http://localhost:8080/cancel");
//            .setInvoiceCreation(SessionCreateParams.InvoiceCreation.builder().setEnabled(true).build())

        for (int i = 0; i < 5; i++) {
            SessionCreateParams.LineItem.PriceData.ProductData productData =
                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName(request.getName())
                    .build();

            SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(request.getCurrency() != null ? request.getCurrency() : "USD")
                .setUnitAmount(request.getAmount())
                .setProductData(productData)
                .build();

            SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setQuantity(request.getQuantity())
                .setPriceData(priceData)
                .build();

            paramsBuilder.addLineItem(lineItem);
        }


        Session session = null;

        try {
            session = Session.create(paramsBuilder.build());
        }catch (StripeException e){
            logger.error(e.getMessage());

        }

        return StripeResponse.builder()
                .status("Success")
                .message("Payment session created")
                .sessionId(session.getId())
                .sessionUrl(session.getUrl())
                .build();
    }

    public String integratedCheckout(ChargeRequestDTO1 dto) throws StripeException {
        Customer customer = customer = StripeCustomerUtil.findOrCreateCustomer(dto.getEmail(), dto.getName());

        PaymentIntent paymentIntent;
        if (!dto.isInvoiceNeeded()) {
            // If invoice is not needed, create a PaymentIntent directly and send it to the client
            PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                    .setAmount(100L)
                    .setCurrency("usd")
                    .setCustomer(customer.getId())
                    .setAutomaticPaymentMethods(
                            PaymentIntentCreateParams.AutomaticPaymentMethods
                                    .builder()
                                    .setEnabled(true)
                                    .build()
                    )
                    .build();

            paymentIntent = PaymentIntent.create(params);
        } else {
            // If invoice is needed, create the invoice object, add line items to it, and finalize it to create the PaymentIntent automatically
            InvoiceCreateParams invoiceCreateParams = new InvoiceCreateParams.Builder()
                    .setCustomer(customer.getId())
                    .build();

            Invoice invoice = Invoice.create(invoiceCreateParams);

            // Add each item to the invoice one by one
            for (ProductRequestDTO product : dto.getProducts()) {

                // Look for existing Product in Stripe before creating a new one
                Product stripeProduct;

                ProductSearchResult results = Product.search(ProductSearchParams.builder()
//                        .setQuery("metadata['app_id']:'" + product.getId() + "'")
                        .build());

                if (!results.getData().isEmpty())
                    stripeProduct = results.getData().get(0);
                else {
                    // If a product is not found in Stripe database, create it
                    ProductCreateParams productCreateParams = new ProductCreateParams.Builder()
                        .setName(product.getName())
//                        .putMetadata("app_id", product.getId())
                        .build();

                    stripeProduct = Product.create(productCreateParams);
                }

                // Create an invoice line item using the product object for the line item
                InvoiceItemCreateParams invoiceItemCreateParams = new InvoiceItemCreateParams.Builder()
                    .setInvoice(invoice.getId())
                    .setQuantity(1L)
                    .setCustomer(customer.getId())
                    .setPriceData(
                        InvoiceItemCreateParams.PriceData.builder()
                                .setProduct(stripeProduct.getId())
                                .setCurrency(product.getCurrency())
                                .setUnitAmount(product.getAmount())
                                .build())
                    .build();

                InvoiceItem.create(invoiceItemCreateParams);
            }

            // Mark the invoice as final so that a PaymentIntent is created for it
            invoice = invoice.finalizeInvoice();

            // Retrieve the payment intent object from the invoice
            paymentIntent = PaymentIntent.retrieve(invoice.getPaymentIntent());
        }
//
//        // Send the client secret from the payment intent to the client
        return paymentIntent.getClientSecret();
    }


}