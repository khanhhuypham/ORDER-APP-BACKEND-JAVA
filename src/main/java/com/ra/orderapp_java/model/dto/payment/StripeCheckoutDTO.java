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
}
