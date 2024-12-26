package com.ra.orderapp_java.model.dto.item;

import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "category_type is not empty")
    private CATEGORY_TYPE category_type;
    private Long category_id;
    private Long unit_id;
    private Long printer_id;
    List<ChildrenDTO> children;

    // Inner DTO for the Order object
    @Getter
    @Setter
    public static class ChildrenDTO {
        private Long id;
        private Float quantity;
        public ChildrenDTO(Long id,Float quantity) {
            this.id = id;
            this.quantity = quantity;
        }
    }
}

