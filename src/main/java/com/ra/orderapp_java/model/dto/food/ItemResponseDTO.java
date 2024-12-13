package com.ra.orderapp_java.model.dto.food;


import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String image;
    private boolean out_of_stock;
    private boolean sell_by_weight;
    private String description;
    private Long category_id;
    private String unit_type;
    private Long printer_id;
    List<ChildrenItemResponseDTO> children;

    public ItemResponseDTO(Item item, List<ChildrenItem> list) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.image = item.getImage();
        this.out_of_stock = item.getOut_of_stock();
        this.sell_by_weight = item.getSell_by_weight();
        this.description = item.getDescription();
        this.printer_id = item.getPrinter().getId();
        this.category_id = item.getCategory().getId();
        this.unit_type = item.getUnit().getName();
        this.children = list.stream().map(ChildrenItemResponseDTO::new).collect(Collectors.toList());
    }
}
