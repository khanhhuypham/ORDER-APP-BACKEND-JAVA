package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentResponseDTO> findAll();
    PaymentResponseDTO create(Long id, PaymentRequestDTO dto);
    PaymentResponseDTO findById(Long id);
}
