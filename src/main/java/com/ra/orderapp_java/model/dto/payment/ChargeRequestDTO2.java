package com.ra.orderapp_java.model.dto.payment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChargeRequestDTO2 {

    public enum Currency {
        EUR, USD, VND, JPY;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
}
