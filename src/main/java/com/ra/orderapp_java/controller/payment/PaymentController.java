package com.ra.orderapp_java.controller.payment;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.payment.PaymentRequestDTO;
import com.ra.orderapp_java.model.dto.payment.PaymentResponseDTO;

import com.ra.orderapp_java.service.payment.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping
    public ResponseEntity<GenericResponse<List<PaymentResponseDTO>>> index(){
        return new ResponseEntity<>(GenericResponse.success(paymentService.findAll()), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<PaymentResponseDTO> create(@RequestBody PaymentRequestDTO dto){
//        return new ResponseEntity<>(paymentService.create(null,dto), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        PaymentResponseDTO dto = paymentService.findById(id);

        return dto == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(paymentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> update(@PathVariable Long id, @RequestBody PaymentRequestDTO dto){
        return new ResponseEntity<>(paymentService.create(id,dto),HttpStatus.CREATED);
    }


}
