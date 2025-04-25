package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.entity.Order;

import java.util.List;

public interface OrderService {
    PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto);
    Order create(Long id, OrderRequestDTO dto) throws CustomException;
    void saveItemToOrder(Long orderId, AddItemToOrderRequestDTO dto) throws CustomException;
    void cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList) throws CustomException;
    void cancelOrder(Long id) throws CustomException;
    OrderResponseDTO findOrderResponseDTOById(Long id);
    Order findOrderById(Long id) throws CustomException;
    Order findIncompleteOrderByTableId(Long id);
}
