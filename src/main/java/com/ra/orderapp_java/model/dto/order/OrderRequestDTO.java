package com.ra.orderapp_java.model.dto.order;

import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.model.entity.TableEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequestDTO {
    private Long table_id;
}