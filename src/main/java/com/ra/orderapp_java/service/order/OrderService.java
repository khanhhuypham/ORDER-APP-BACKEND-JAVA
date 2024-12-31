package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto);
    OrderResponseDTO create(Long id, OrderRequestDTO dto);
    OrderResponseDTO saveItemToOrder(Long orderId, AddItemToOrderRequestDTO dto);
    OrderResponseDTO cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList);
    OrderResponseDTO findById(Long id);

}
