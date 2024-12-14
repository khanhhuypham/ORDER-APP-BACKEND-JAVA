package com.ra.orderapp_java.model.dto.food;

import jakarta.validation.constraints.Min;
import lombok.*;

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
    private Long category_id;
}
