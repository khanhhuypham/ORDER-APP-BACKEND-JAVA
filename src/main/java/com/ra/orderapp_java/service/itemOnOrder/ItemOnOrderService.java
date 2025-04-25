package com.ra.orderapp_java.service.itemOnOrder;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.advice.CustomRuntimeException;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import com.ra.orderapp_java.model.entity.Order;

import java.util.List;

public interface ItemOnOrderService {
    List<ItemOnOrder> findItemsByOrderId(Long orderId);
    ItemOnOrder findItemByOrderId(Long itemId, Long orderId) throws CustomException;
    void addItemToOrder(Long orderId, AddItemToOrderRequestDTO dto) throws CustomException;
    void cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList) throws CustomException;
    void reassignOrderItemToOrder(Order order, ItemOnOrder item) throws CustomException;
    void delete(Long id);
}
