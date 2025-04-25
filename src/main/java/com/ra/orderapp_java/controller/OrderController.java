package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
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
    public ResponseEntity<ResponseWrapper<PaginationDTO<OrderResponseDTO>>> index(@ModelAttribute OrderQueryDTO dto){
        return new ResponseEntity<>(
            ResponseWrapper.success(
                orderService.findAll(dto)
            ),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<OrderResponseDTO>> findById(@PathVariable Long id){

        OrderResponseDTO dto = orderService.findOrderResponseDTOById(id);

        return new ResponseEntity<>(
            ResponseWrapper.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper<OrderResponseDTO>> create(@RequestBody OrderRequestDTO dto) throws CustomException {
        OrderResponseDTO result =  new OrderResponseDTO(orderService.create(null,dto));

        return new ResponseEntity<>(
            ResponseWrapper.success(result),
            HttpStatus.CREATED
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<OrderResponseDTO>> update(@PathVariable Long id, @RequestBody OrderRequestDTO dto) throws CustomException {
        OrderResponseDTO result =  new OrderResponseDTO(orderService.create(id,dto));
        return new ResponseEntity<>(
            ResponseWrapper.success(result),
            HttpStatus.CREATED
        );
    }


    @PutMapping("/{id}/add-items")
    public ResponseEntity<ResponseWrapper<String>> addItems(@PathVariable Long id, @RequestBody AddItemToOrderRequestDTO list) throws CustomException {

        orderService.saveItemToOrder(id,list);

        return new ResponseEntity<>(
            ResponseWrapper.success("Add successfully"),
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}/cancel-items")
    public ResponseEntity<ResponseWrapper<String>> cancelItems(@PathVariable Long id, @RequestBody List<CancelItemOnOrderDTO> list) throws CustomException {
        orderService.cancelItemOfOrder(id,list);

        return new ResponseEntity<>(
                ResponseWrapper.success("Cancel items successfully"),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}/cancel")
    public ResponseEntity<ResponseWrapper<String>> cancelOrder(@PathVariable Long id) throws CustomException {
        orderService.cancelOrder(id);
        return new ResponseEntity<>(ResponseWrapper.success("Cancel order successfully"), HttpStatus.OK);
    }

}
