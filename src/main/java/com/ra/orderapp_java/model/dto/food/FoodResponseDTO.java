package com.ra.orderapp_java.model.dto.food;


import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.Item;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String image;
    private Category category;

    public FoodResponseDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.image = item.getImage();
        this.category = item.getCategory();
    }
}
