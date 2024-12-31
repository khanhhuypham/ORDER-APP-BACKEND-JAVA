package com.ra.orderapp_java.model.dto.payment;

import com.ra.orderapp_java.model.entity.Payment;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentResponseDTO {
    private Long id;
    private Double discount;
    private Double tax;
    private Double surcharge;
    private Double amount;
    private Double net_amount;
    private Integer method;
    private Integer status;

    public PaymentResponseDTO(Payment payment) {
        this.id = payment.getId();
        this.discount = payment.getDiscount();
        this.tax =  payment.getTax();
        this.surcharge = payment.getSurcharge();
        this.amount = payment.getAmount();
        this.net_amount = payment.getNet_amount();
        this.method = payment.getMethod();
        this.status = payment.getStatus().getValue();
    }
}
