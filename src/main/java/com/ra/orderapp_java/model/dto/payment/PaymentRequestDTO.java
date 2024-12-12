package com.ra.orderapp_java.model.dto.payment;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Double amount;
    private Double net_amount;
    private Integer method;
    private Integer status;
}
