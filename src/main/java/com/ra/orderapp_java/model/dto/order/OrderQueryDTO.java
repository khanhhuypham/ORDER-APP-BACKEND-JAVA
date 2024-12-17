package com.ra.orderapp_java.model.dto.order;

import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderQueryDTO {
    private String search_key;
    private ORDER_STATUS status;
    @Min(value = 0,message = "user_id invalid")
    private Long user_id;
    private ORDER_TYPE type;

    private Integer limit;
    @Min(value = 1,message = "page must be greater than 1")
    private Integer page;
}