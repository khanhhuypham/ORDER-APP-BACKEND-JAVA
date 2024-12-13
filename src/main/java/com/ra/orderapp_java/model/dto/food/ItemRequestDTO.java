package com.ra.orderapp_java.model.dto.food;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.Item;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemRequestDTO {

    private String name;
    private Double price;
    private String image;
    private Boolean sell_by_weight;
    private String description;
    private Long category_id;
    private Long unit_id;
    private Long printer_id;
    List<ChildrenItemResponseDTO> children;

}
