package com.ra.orderapp_java.model.dto.payment;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
//    @Min(value = 100,message = "loi ")
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
//  private boolean invoiceNeeded;
}
