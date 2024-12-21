package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;

import com.ra.orderapp_java.repository.OrderRepository;
import com.ra.orderapp_java.repository.joinEntity.ItemOnOrderRepository;
import com.ra.orderapp_java.service.item.ItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;
@Transactional
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    public final OrderRepository orderRepo;
    public final ItemOnOrderRepository orderOnItemRepo;
    public final ItemService itemService;

    @Override
    public PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto) {

        Pageable pageable  = PageRequest.of(dto.getPage() - 1, dto.getLimit());
        List<ORDER_STATUS> status = null;

        if (dto.getStatus() != null){
            status = dto.getStatus().stream()
                .map(ORDER_STATUS::fromValue)
                .collect(Collectors.toList());
        }


        System.out.println(dto.getType());
        Page<Order> result = orderRepo.findAllByCondition(
            null,
            dto.getSearch_key(),
            null,
            dto.getType(),
            pageable
        );

        List<OrderResponseDTO> list = result.stream()
            .map(order -> {
                OrderResponseDTO newDTO = new OrderResponseDTO(order);
                newDTO.excludeProperty("items");
                return newDTO;
            })
            .collect(Collectors.toList());

        return PaginationDTO.input(list,result);
    }

    @Override
    public OrderResponseDTO create(Long id, OrderRequestDTO dto) {
        return null;
    }

    @Override
    public void saveItemToOrder(Long id, List<Item> itemList) {
        Order order = orderRepo.findById(id).orElse(null);

        if (order != null) {
            // Precompute IDs of items already in the order for quick lookup
            Set<Long> existingItemIds = order.getItems().stream()
                    .map(orderOnItem -> orderOnItem.getItem().getId())
                    .collect(Collectors.toSet());

            for (Item item : itemList) {
                if (existingItemIds.contains(item.getId())) {
                    // Item is already in the order
                    ItemOnOrder itemOnOrder = orderOnItemRepo.findByItemId(item.getId());
                    if (itemOnOrder != null) {
                        itemOnOrder.setQuantity(2F); // Update the quantity
                        orderOnItemRepo.save(itemOnOrder); // Persist the update
                    }
                } else {
                    // Item is not in the order, create a new OrderOnItem
                    ItemOnOrder newItemOnOrder = new ItemOnOrder(order, item); // Assuming constructor accepts Order and Item
                    orderOnItemRepo.save(newItemOnOrder);
                }
            }
        }

    }

    @Override
    public void cancelItemOfOrder(Long id, List<Item> itemList) {
        Order order = orderRepo.findById(id).orElse(null);
        if (order != null) {
            // Precompute IDs of items already in the order for quick lookup
            Set<Long> existingItemIds = order.getItems().stream()
                    .map(orderOnItem -> orderOnItem.getItem().getId())
                    .collect(Collectors.toSet());

            for (Item item : itemList) {
                if (existingItemIds.contains(item.getId())) {
                    // Item is already in the order
                    ItemOnOrder itemOnOrder = orderOnItemRepo.findByItemId(item.getId());

                    if (itemOnOrder != null) {
//                        orderOnItem.setStatus();
                        orderOnItemRepo.save(itemOnOrder); // Persist the update
                    }
                }
            }
        }

    }




    @Override
    public OrderResponseDTO findById(Long id) {

        Order order = orderRepo.findById(id).orElse(null);
        List<ItemResponseDTO> list = new ArrayList<>();


        if (order != null){
            for(ItemOnOrder element: order.getItems()){
                ItemResponseDTO item = itemService.findById(element.getItem().getId());

                for (int i = 0; i < item.getChildren().size(); i++) {
                    item.getChildren().get(i).filterPropertiesForOrDetailDTO();
                }


                item.filterPropertiesForOrDetailDTO(element);
                list.add(item);
            }

        }

        OrderResponseDTO dto = new OrderResponseDTO(order,list);
        dto.filterPropertiesForOrDetailDTO();

        return order == null ? null : dto;
    }

    @Override
    public void delete(Long id) {

    }
}
