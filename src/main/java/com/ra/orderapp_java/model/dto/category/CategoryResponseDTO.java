package com.ra.orderapp_java.model.dto.category;


import com.ra.orderapp_java.model.entity.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private Boolean active;
    private Integer type;
    private String description;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.active = category.getActive();
        this.type = category.getType().getValue();
        this.description = category.getDescription();
    }
}
