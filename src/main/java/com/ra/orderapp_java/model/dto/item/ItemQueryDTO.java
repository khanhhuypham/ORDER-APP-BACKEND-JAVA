package com.ra.orderapp_java.model.dto.item;

import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemQueryDTO {
    private String search_key;
    private Integer status;
    private Integer limit;
    @Min(value = 1,message = "page must be greater than 1")
    private Integer page;
    private List<Integer> category_type;
    private Long category_id;
    private Boolean out_of_stock;

}
