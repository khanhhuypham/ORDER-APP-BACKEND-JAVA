package com.ra.orderapp_java.model.dto.childrenItem;

import com.ra.orderapp_java.model.entity.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChildrenItemResponseDTO {
    private Long id;
    private String name;
    private String image;
    private Double price;
    private Long category_id;
    private String unit_type;
    private String description;

    public ChildrenItemResponseDTO(ChildrenItem childrenItem) {
        this.id = childrenItem.getId();
        this.name = childrenItem.getName();
        this.price = childrenItem.getPrice();
        this.image = childrenItem.getImage();
        this.description = childrenItem.getDescription();
        this.category_id = childrenItem.getCategory().getId();
        this.unit_type = childrenItem.getUnit().getName();
    }
}
