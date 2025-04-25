package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;
import com.ra.orderapp_java.model.entity.Payment;


import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    Payment create(Long id, PaymentRequestDTO dto)  throws CustomException;
    Payment findById(Long id) throws CustomException;
}
