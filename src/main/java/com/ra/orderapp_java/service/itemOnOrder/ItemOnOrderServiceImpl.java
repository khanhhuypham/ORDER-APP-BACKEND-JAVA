package com.ra.orderapp_java.service.itemOnOrder;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.advice.CustomRuntimeException;
import com.ra.orderapp_java.model.constant.ITEM_ON_ORDER_STATUS;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.repository.OrderRepository;
import com.ra.orderapp_java.repository.joinEntity.ItemOnOrderRepository;
import com.ra.orderapp_java.service.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

@AllArgsConstructor
@Service
public class ItemOnOrderServiceImpl implements ItemOnOrderService {
    public final OrderRepository orderRepo;
    public final ItemOnOrderRepository itemOnOrderRepo;
    public final ItemService itemService;

    @Override
    public List<ItemOnOrder> findItemsByOrderId(Long orderId){
        return itemOnOrderRepo.findAllByOrderId(orderId);
    }

    @Override
    public ItemOnOrder findItemByOrderId(Long itemId, Long orderId) throws CustomException {
        ItemOnOrder itemOnOrder = itemOnOrderRepo.findByItemId(itemId,orderId).orElse(null);
        if (itemOnOrder == null) {
            throw new CustomException(String.format("item %d not found in order %d",itemId,orderId),HttpStatus.NOT_FOUND);
        }
        return itemOnOrder;
    }


    @Override
    public void addItemToOrder(Long orderId, AddItemToOrderRequestDTO dto) throws CustomException {
        Order order = this.findOrderById(orderId);

        // Precompute IDs of items already in the order for quick lookup
        Set<Long> existingItemIds = order.getItems().stream()
                .map(item -> item.getItem().getId())
                .collect(toSet());

        for (ItemOnOrderDTO element : dto.getItems()) {

            Item item = itemService.findItemById(element.getId());

            if (item != null){
                if (existingItemIds.contains(item.getId())) {
                    // Item is already in the order
                    ItemOnOrder itemOnOrder = itemOnOrderRepo.findByItemId(item.getId(),orderId).orElse(null);

                    if (itemOnOrder != null) {
                        itemOnOrder.setQuantity(element.getQuantity()); // Update the quantity
                        itemOnOrderRepo.save(itemOnOrder); // Persist the update
                    }

                } else {
                    // Item is not in the order, create a new OrderOnItem
                    ItemOnOrder newItemOnOrder = new ItemOnOrder(order,item,element); // Assuming constructor accepts Order and Item
                    itemOnOrderRepo.save(newItemOnOrder);
                }
            }
        }

    }

    @Override
    public void cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList) throws CustomException {
        Order order = this.findOrderById(orderId);
//
        // Precompute IDs of items already in the order for quick lookup
        Set<Long> existingItemIds = order.getItems().stream()
            .map(orderOnItem -> orderOnItem.getItem().getId())
            .collect(toSet());

        for (CancelItemOnOrderDTO cancelItem : itemList) {
            if (existingItemIds.contains(cancelItem.getId())) {
                // Item is already in the order
                ItemOnOrder itemOnOrder = itemOnOrderRepo.findByItemId(cancelItem.getId(),orderId).orElse(null);

                if (itemOnOrder != null) {
                    itemOnOrder.setStatus(ITEM_ON_ORDER_STATUS.CANCELLED);
                    itemOnOrderRepo.save(itemOnOrder); // Persist the update
                }

            }else{
                throw new CustomException(
                    String.format("item %d not found in order",cancelItem.getId()),
                    HttpStatus.NOT_FOUND
                );
            }
        }
    }

    @Override
    public void reassignOrderItemToOrder(Order order, ItemOnOrder item) throws CustomException {
        item.setOrder(this.findOrderById(order.getId()));
        itemOnOrderRepo.save(item);
    }


    @Override
    public void delete(Long id) {

    }


    private Order findOrderById(Long id) throws CustomException {
        Order order = orderRepo.findById(id).orElse(null);

        if (order == null){
            throw new CustomException("Not found", HttpStatus.NOT_FOUND);
        }

        return order;
    }
}
