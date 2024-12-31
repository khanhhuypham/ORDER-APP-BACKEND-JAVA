package com.ra.orderapp_java.model.dto.payment;

import com.ra.orderapp_java.model.constant.PAYMENT_STATUS;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequestDTO {
    private Double discount;
    private Double tax;
    private Double surcharge;
    private Integer method;
}
