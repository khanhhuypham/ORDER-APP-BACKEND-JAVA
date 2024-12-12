package com.ra.orderapp_java.model.dto.payment;

import com.stripe.model.Product;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChargeRequestDTO1 {
    ProductRequestDTO[] products;
    String name;
    String email;
    String subscriptionId;
    boolean invoiceNeeded;
}
