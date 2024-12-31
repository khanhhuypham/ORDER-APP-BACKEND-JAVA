package com.ra.orderapp_java.model.dto.order;

import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.model.entity.TableEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequestDTO {

    @Positive(message = "Table ID must be a positive number")
    private Long table_id;

    @Positive(message = "User ID must be a positive number")
    private Long user_id;

    @NotNull(message = "Order type cannot be null")
    private ORDER_TYPE order_type;
}