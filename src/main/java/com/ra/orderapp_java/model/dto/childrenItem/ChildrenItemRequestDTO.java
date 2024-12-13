package com.ra.orderapp_java.model.dto.childrenItem;

import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.Unit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChildrenItemRequestDTO {
    private String name;
    private String image;
    private Double price;
    private Long category_id;
    private Long unit_id;
    private Boolean out_of_stock;
    private String description;
}
