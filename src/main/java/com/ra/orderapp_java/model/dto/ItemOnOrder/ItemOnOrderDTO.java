package com.ra.orderapp_java.model.dto.ItemOnOrder;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemOnOrderDTO {
    private Long id;
    private Float quantity;
    private Double discount_amount;
    private Integer discount_percent;
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
