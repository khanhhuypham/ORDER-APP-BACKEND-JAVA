package com.ra.orderapp_java.service.payment;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.repository.PaymentRepository;
import org.springframework.http.HttpStatus;
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
    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment create(Long id, PaymentRequestDTO dto)  throws CustomException{
        Payment payment = null;

        if (id != null){
            payment = this.findById(id);
            payment.setDiscount(dto.getDiscount());
            payment.setTax(dto.getTax());
            payment.setSurcharge(dto.getSurcharge());
            payment.setMethod(dto.getMethod());
        }else {
            payment = new Payment();
        }

      return payment;

    }

    @Override
    public Payment findById(Long id) throws CustomException {
        Payment payment = paymentRepo.findById(id).orElse(null);
        if (payment == null){
            throw new CustomException("Payment not found", HttpStatus.NOT_FOUND);
        }

        return payment;
    }

}
