package com.ra.orderapp_java.controller.payment;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;

import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.service.payment.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper<List<PaymentResponseDTO>>> index(){

        List<PaymentResponseDTO> list = new ArrayList();
        for(Payment payment : paymentService.findAll()) {
            list.add(new PaymentResponseDTO(payment));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<PaymentResponseDTO> create(@RequestBody PaymentRequestDTO dto){
//        return new ResponseEntity<>(paymentService.create(null,dto), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) throws CustomException {
        PaymentResponseDTO dto = new PaymentResponseDTO(paymentService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> update(@PathVariable Long id, @RequestBody PaymentRequestDTO dto) throws CustomException {
        PaymentResponseDTO result = new PaymentResponseDTO(paymentService.create(id,dto));
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }


}
