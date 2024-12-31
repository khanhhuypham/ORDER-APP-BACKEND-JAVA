package com.ra.orderapp_java.model.dto.order;

import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderQueryDTO {
    @Size(max = 100, message = "search_key cannot exceed 100 characters")
    private String search_key;

    private List<Integer> status;

    @Min(value = 0,message = "user_id invalid")
    private Long user_id;

    private ORDER_TYPE type;

    private Integer limit;

    @Min(value = 1,message = "page must be greater than 1")
    private Integer page;
}