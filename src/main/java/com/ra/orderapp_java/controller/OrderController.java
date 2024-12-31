package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.service.order.OrderService;

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

    @PostMapping("/create")
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


    @PutMapping("/{id}/add-items")
    public ResponseEntity<GenericResponse<OrderResponseDTO>> addItems(@PathVariable Long id, @RequestBody AddItemToOrderRequestDTO list){
        return new ResponseEntity<>(
            GenericResponse.success(orderService.saveItemToOrder(id,list)),
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}/cancel-items")
    public ResponseEntity<GenericResponse<OrderResponseDTO>> cancelItems(@PathVariable Long id, @RequestBody List<CancelItemOnOrderDTO> list){
        return new ResponseEntity<>(
                GenericResponse.success(orderService.cancelItemOfOrder(id,list)),
                HttpStatus.CREATED
        );
    }

}
