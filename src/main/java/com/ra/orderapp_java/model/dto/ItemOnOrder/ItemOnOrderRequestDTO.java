package com.ra.orderapp_java.model.dto.ItemOnOrder;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.Order;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemOnOrderRequestDTO {
    private Long id;
    private Float quantity;
    private Double discount;
    private Integer status;
    private String note;
    private List<ChildrenDTO> children;

    // Inner DTO for the Order object
    @Getter
    @Setter
    private static class ChildrenDTO {
        private Long id;
        private Float quantity;
        public ChildrenDTO(Long id,Float quantity) {
            this.id = id;
            this.quantity = quantity;
        }
    }
}
