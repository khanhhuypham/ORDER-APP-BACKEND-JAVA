package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;
import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    public final PaymentRepository paymentRepo;

    public PaymentServiceImpl(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }


    @Override
    public List<PaymentResponseDTO> findAll() {
        List<PaymentResponseDTO> list = new ArrayList();
        for(Payment payment : paymentRepo.findAll()) {
            list.add(new PaymentResponseDTO(payment));
        }
        return list;
    }

    @Override
    public PaymentResponseDTO create(Long id, PaymentRequestDTO dto) {
        Payment payment = paymentRepo.save(Payment.builder()
                .id(id)
                .discount(dto.getDiscount())
                .tax(dto.getTax())
                .surcharge(dto.getSurcharge())
                .amount(dto.getAmount())
                .net_amount(dto.getNet_amount())
                .method(dto.getMethod())
                .status(dto.getStatus())
                .build());
        return new PaymentResponseDTO(payment);
    }

    @Override
    public PaymentResponseDTO findById(Long id) {
        Payment payment = paymentRepo.findById(id).orElse(null);
        return payment == null ? null : new PaymentResponseDTO(payment);
    }

}
