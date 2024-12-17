package com.ra.orderapp_java.model.dto.order;

import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnItem;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponseDTO {
    private Long id;
    private Integer status;
    private Integer type;
    private String using_time;
    private String using_slot;

    private Double net_amount;
    private Integer booking_status;

    private Long table_id;
    private String table_name;
    private String table_merged_names;


    public OrderResponseDTO(Order order,TableEntity table) {
        this.id = order.getId();
        this.status = order.getStatus().getValue();
        this.type = order.getType().getValue();
        this.using_time = order.getUsing_time();
        this.using_slot = order.getUsing_slot();
        this.net_amount = order.getPayment().getNet_amount();
        this.table_id = table.getId();
        this.table_name = table.getName();
    }
}
