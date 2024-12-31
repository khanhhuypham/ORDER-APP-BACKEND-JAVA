package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.model.constant.ITEM_ON_ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.dto.ItemOnOrder.AddItemToOrderRequestDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.CancelItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;

import com.ra.orderapp_java.repository.OrderRepository;
import com.ra.orderapp_java.repository.PaymentRepository;
import com.ra.orderapp_java.repository.TableRepository;
import com.ra.orderapp_java.repository.UserRepository;
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

import static java.util.stream.Collectors.toSet;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    public final TableRepository tableRepo;
    public final UserRepository userRepo;
    public final OrderRepository orderRepo;
    public final PaymentRepository paymentRepo;
    public final ItemService itemService;
    public final ItemOnOrderRepository itemOnOrderRepo;


    @Override
    public PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto) {

        Pageable pageable  = PageRequest.of(dto.getPage() - 1, dto.getLimit());
        List<ORDER_STATUS> status = null;

        if (dto.getStatus() != null){
            status = dto.getStatus().stream()
                .map(ORDER_STATUS::fromValue)
                .collect(Collectors.toList());
        }

        Page<Order> result = orderRepo.findAllByCondition(
            status,
            dto.getSearch_key(),
            dto.getUser_id(),
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

        Order order = new Order();
        Payment payment = paymentRepo.save(Payment.builder().build());
        User user = userRepo.findById(dto.getUser_id()).orElse(null);
        order.setPayment(payment);
        order.setUser(user);

        if (dto.getOrder_type() == ORDER_TYPE.DINE_IN){
            TableEntity table = tableRepo.findById(dto.getTable_id()).orElse(null);
            if (table != null ){
                order.setTable(table);
            }
        }

        Order savedOrder = orderRepo.save(order);
        return new OrderResponseDTO(order);
    }

    @Override
    public OrderResponseDTO saveItemToOrder(Long orderId, AddItemToOrderRequestDTO dto) {
        Order order = orderRepo.findById(orderId).orElse(null);

        if (order != null) {
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
                        System.out.println(newItemOnOrder.getStatus());
                        itemOnOrderRepo.save(newItemOnOrder);
                    }
                }
            }
        }
       return this.findById(orderId);
    }

    @Override
    public OrderResponseDTO cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order != null) {
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
                }
            }
        }

        return this.findById(orderId);
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


}
