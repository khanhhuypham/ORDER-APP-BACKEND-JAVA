package com.ra.orderapp_java.model.dto.table;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.ra.orderapp_java.model.constant.ORDER_STATUS;

import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.TableEntity;
import lombok.*;

import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TableResponseDTO {
    private Long id;
    private String name;
    private Boolean active;
    private Long area_id;
    private Long total_slot;
    private OrderDTO order;
    private String merge_table;

    public TableResponseDTO(TableEntity table) {
        this.id = table.getId();
        this.name = table.getName();

        // Find the active order (assuming only one active order per table)
        if (table.getOrders() != null) {
            for (Order order : table.getOrders()) {
                if (order != null && order.getStatus() != ORDER_STATUS.COMPLETE) {
                    this.order = new OrderDTO(order); // Create an OrderDTO
                    break; // Exit the loop after finding the first active order
                }
            }
        }

        this.active = table.getActive();
        if (table.getArea() != null) {
            this.area_id = table.getArea().getId();
        }

        if (table.getMerge_tables() != null) {
            this.merge_table = table.getMerge_tables().toString();
        }

        this.total_slot = table.getTotal_slot();
    }

    // Inner DTO for the Order object
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class OrderDTO {
        private Long id;
        private Integer status;
        public OrderDTO(Order order) {
            this.id = order.getId();
            this.status = order.getStatus().getValue();
        }
    }
}