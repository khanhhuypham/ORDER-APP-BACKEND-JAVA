package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.item.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.item.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.service.order.OrderService;
import com.ra.orderapp_java.service.printer.PrinterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<PaginationDTO<OrderResponseDTO>>> index(@ModelAttribute OrderQueryDTO dto){


        return new ResponseEntity<>(
            GenericResponse.success(
                orderService.findAll(dto)
            ),
            HttpStatus.OK
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<OrderResponseDTO>> findById(@PathVariable Long id){
        OrderResponseDTO dto = orderService.findById(id);
        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<GenericResponse<OrderResponseDTO>> create(@RequestBody OrderRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(orderService.create(null,dto)),
            HttpStatus.CREATED
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<OrderResponseDTO>> update(@PathVariable Long id, @RequestBody OrderRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(orderService.create(id,dto)),
            HttpStatus.CREATED
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<?>> addItems(@PathVariable Long id, @RequestBody OrderRequestDTO dto){
        return new ResponseEntity<>(
                GenericResponse.success(orderService.saveItemToOrder(id,null)),
                HttpStatus.CREATED
        );
    }



}
