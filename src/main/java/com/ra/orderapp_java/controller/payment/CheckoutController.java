package com.ra.orderapp_java.controller.payment;

import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.payment.StripeCheckoutDTO;
import com.ra.orderapp_java.model.dto.payment.StripeResponse;
import com.ra.orderapp_java.service.payment.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerSearchResult;
import com.stripe.param.CustomerSearchParams;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CheckoutController {

    private final StripeService stripeService;
    private Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    public CheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

//    @PostMapping()
//    public ChargeResponse charge(@RequestBody ChargeRequest chargeRequest) throws StripeException {
//        Charge charge = stripeService.charge(chargeRequest);
//        ChargeResponse res = new ChargeResponse();
//        return null;
//    }


    @GetMapping
    public ResponseEntity<?> searchasd(){
        Stripe.apiKey = "sk_test_51QMR90B2kW4hnJAbDWoRm8G28WlAuUcRIpqEmKrMCuS1mOeJOU5GC9M03HqZxAQO47SsIzgsuwnG4zSCvyjNKQr500ZDCoVImu";
		CustomerSearchParams params =
				CustomerSearchParams.builder()
						.setQuery("name:'Jane Doe' AND metadata['foo']:'bar'")
						.build();

        CustomerSearchResult customers = null;
        try {
            customers = Customer.search(params);
        } catch (StripeException e) {
            logger.error(e.getMessage());
            new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @PostMapping("/stripe-host-checkout")
    public ResponseEntity<ResponseWrapper<?>> checkoutProducts(@Valid @RequestBody StripeCheckoutDTO dto) throws StripeException {

        StripeResponse stripeResponse = stripeService.checkout(dto);

        return new ResponseEntity<>(
            ResponseWrapper.success(stripeResponse),
            HttpStatus.CREATED
        );

    }

    @PostMapping("/host-checkout")
    public ResponseEntity<?> integratedCheckout(@RequestBody StripeCheckoutDTO dto) throws StripeException {

        String stripeResponse = stripeService.integratedCheckout(dto);

        return new ResponseEntity<>(
            ResponseWrapper.success(stripeResponse),
            HttpStatus.CREATED
        );

    }

}
        