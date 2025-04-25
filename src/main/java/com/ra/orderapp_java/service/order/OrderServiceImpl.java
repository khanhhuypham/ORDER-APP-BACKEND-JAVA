package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.advice.CustomException;
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
import com.ra.orderapp_java.service.itemOnOrder.ItemOnOrderService;
import com.ra.orderapp_java.service.payment.PaymentService;
import com.ra.orderapp_java.service.table.TableService;
import com.ra.orderapp_java.service.user.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public final OrderRepository orderRepo;
    public final UserService userService;
    public final PaymentService paymentService;
    public final ItemService itemService;
    public final ItemOnOrderService itemOnOrderService;


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
    public Order create(Long id, OrderRequestDTO dto) throws CustomException{

        Order order = null;

        if (id == null){
            order = new Order();
            order.setPayment(paymentService.create(null,null));
            order.setUser(userService.findById(dto.getUser_id()));

            //only order type equal dine_in has table
            if (dto.getOrder_type() == ORDER_TYPE.DINE_IN){
                order.setTable(this.findTableById(dto.getTable_id()));
            }

        }else{
            order = this.findOrderById(id);
            order.setTable(this.findTableById(dto.getTable_id()));
        }


        return orderRepo.save(order);
    }

    @Override
    public void saveItemToOrder(Long orderId, AddItemToOrderRequestDTO dto) throws CustomException{
        itemOnOrderService.addItemToOrder(orderId,dto);
    }

    @Override
    public void cancelItemOfOrder(Long orderId, List<CancelItemOnOrderDTO> itemList) throws CustomException{
        itemOnOrderService.cancelItemOfOrder(orderId,itemList);
    }

    @Override
    public void cancelOrder(Long id) throws CustomException{
        Order order = this.findOrderById(id);

        System.out.println(order.getItems().stream().anyMatch(item -> {
                System.out.println(item.getStatus());
                return item.getStatus() != ITEM_ON_ORDER_STATUS.CANCELLED;
            })
        );

        Boolean condition = !order.getItems().stream().anyMatch(item -> item.getStatus() != ITEM_ON_ORDER_STATUS.CANCELLED);
//                && order.getPayment().getNet_amount() == 0;

        if (condition) {
            order.setStatus(ORDER_STATUS.CANCEL);
            orderRepo.save(order);
        }else{
            throw new CustomException(
                String.format("Unable to cancel Order with id %d", id),
                HttpStatus.BAD_REQUEST);
        }

    }


    @Override
    public OrderResponseDTO findOrderResponseDTOById(Long id){

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
    public Order findOrderById(Long id) throws CustomException {
        Order order = orderRepo.findById(id).orElse(null);

        if (order == null){
            throw new CustomException("Not found", HttpStatus.NOT_FOUND);
        }

        return order;
    }


    @Override
    public Order findIncompleteOrderByTableId(Long id) {
        return orderRepo.findAllByTableId(id)
            .stream()
            .filter(order -> order.getStatus() != ORDER_STATUS.COMPLETE)
            .findFirst()
            .orElse(null);
    }


    private TableEntity findTableById(Long id) throws CustomException {
        TableEntity table = tableRepo.findById(id).orElse(null);

        if (table == null){
            throw new CustomException("Not found", HttpStatus.NOT_FOUND);
        }

        return table;
    }

}
