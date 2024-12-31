package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;


import java.util.List;

public interface PaymentService {
    List<PaymentResponseDTO> findAll();
    PaymentResponseDTO create(Long id, PaymentRequestDTO dto);
    PaymentResponseDTO findById(Long id);
}
