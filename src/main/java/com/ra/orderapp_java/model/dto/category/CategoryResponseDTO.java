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
    private boolean active;
    private String description;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.active = category.getActive();
        this.description = category.getDescription();
    }
}
