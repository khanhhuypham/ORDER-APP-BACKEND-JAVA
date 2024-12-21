package com.ra.orderapp_java.model.dto.ItemOnOrder;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
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
}
