package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderRequestDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.dto.item.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.item.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.entity.Item;

import java.util.List;

public interface OrderService {
    PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto);
    OrderResponseDTO create(Long id, OrderRequestDTO dto);
    void saveItemToOrder(Long id, List<ItemOnOrderRequestDTO> dtoList);
    void cancelItemOfOrder(Long id, List<Item> itemList);
    OrderResponseDTO findById(Long id);
    void delete(Long id);
}
