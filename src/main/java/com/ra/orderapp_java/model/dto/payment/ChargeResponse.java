package com.ra.orderapp_java.model.dto.payment;
import lombok.Data;

@Data
public class ChargeResponse {
    public String status;
    public String id;
    public String transactionId;
}