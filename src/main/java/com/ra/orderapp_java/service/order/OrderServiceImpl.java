package com.ra.orderapp_java.service.order;

import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.item.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.item.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.dto.order.OrderQueryDTO;
import com.ra.orderapp_java.model.dto.order.OrderRequestDTO;
import com.ra.orderapp_java.model.dto.order.OrderResponseDTO;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnTable;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.repository.ItemRepository;
import com.ra.orderapp_java.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    public final OrderRepository orderRepo;
    public final ItemRepository itemRepo;

    @Override
    public PaginationDTO<OrderResponseDTO> findAll(OrderQueryDTO dto) {

        List<OrderResponseDTO> list = new ArrayList();
        Pageable pageable  = PageRequest.of(dto.getPage() - 1, dto.getLimit());

        Page<Order> result = orderRepo.findAllByCondition(
                dto.getStatus(),
                dto.getSearch_key(),
                dto.getUser_id(),
                dto.getType(),
                pageable
        );


        return PaginationDTO.input(list,result);
    }

    @Override
    public OrderResponseDTO create(Long id, OrderRequestDTO dto) {
        return null;
    }

    @Override
    public void addItemToOrder(Long orderId, List<Item> itemList) {

    }

    @Override
    public OrderResponseDTO findById(Long id) {
//        OrderResponseDTO result = null;
//        Order order = orderRepo.findById(id).orElse(null);
//
//        if (order != null) {
//            Optional<OrderOnTable> firstTable = order.getTables().stream()
//                .filter(table -> table.getOrder().getId() == order.getId()) // Use filter instead of findFirst directly
//                .findFirst(); // Now findFirst can be called on the filtered stream
//
//            result = new OrderResponseDTO(order, firstTable.orElse(null)); // Provide a default if no table is found
//        }
//        return OrderResponseDTO(item);
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
