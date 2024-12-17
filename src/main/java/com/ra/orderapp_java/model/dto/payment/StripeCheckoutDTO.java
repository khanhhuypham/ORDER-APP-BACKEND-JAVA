package com.ra.orderapp_java.model.dto.payment;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StripeCheckoutDTO {
    ProductRequestDTO[] items;
    String name;
    String email;
    String successUrl;
    String cancelUrl;
    String subscriptionId;
    boolean invoiceNeeded;


    public Long calculateOrderAmount() {
        long total = 0L;
        for (ProductRequestDTO item: this.items) {
            // Look up the application database to find the prices for the products in the given list
            total += item.getAmount()*item.getQuantity();
        }
        return total;
    }
}
