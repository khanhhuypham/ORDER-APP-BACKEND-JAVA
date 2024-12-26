package com.ra.orderapp_java.model.dto.item;


import com.fasterxml.jackson.annotation.*;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String image;
    private boolean out_of_stock;
    private boolean sell_by_weight;
    private String description;
    private Long category_id;
    private String category_name;
    private Integer category_type;
    private String unit_type;
    private Long unit_id;
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
        if (item.getCategory() != null){
            this.category_id = item.getCategory().getId();
            this.category_name = item.getCategory().getName();
        }
        this.category_type = item.getCategory_type().getValue();
        this.unit_type = item.getUnit().getName();
        this.unit_id = item.getUnit().getId();

        this.children = list.stream().map(child -> {

            ItemOnChildrenItem matching = Optional.ofNullable(item.getChildren())
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(a -> Objects.equals(a.getChildrenItem().getId(), child.getId()))
                    .findFirst()
                    .orElse(null);

            if (matching != null){
                return new ChildrenItemResponseDTO(child,matching.getQuantity());
            }else{
                return new ChildrenItemResponseDTO(child);
            }


        }).collect(Collectors.toList());

        this.additionalProperties = new HashMap<>();
        this.excludedProperties = new HashSet<>();
    }

    public void filterPropertiesForOrDetailDTO(ItemOnOrder item) {
        this.setAdditionalProperty("quantity",item.getQuantity());
        this.setAdditionalProperty("status",item.getStatus().getValue());
        this.setAdditionalProperty("allow_return",item.getAllow_return());
        this.setAdditionalProperty("note",item.getNote());
        this.excludeProperty(
            "out_of_stock",
            "description",
            "category_id",
            "unit_type",
            "category_name",
            "unit_id"
        );
    }


    // Initialize the map
    private Map<String, Object> additionalProperties = new HashMap<>();
    // Keep track of properties to exclude
    private Set<String> excludedProperties = new HashSet<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        // Create a map with all properties
        Map<String, Object> allProperties = new HashMap<>();

        // Add standard properties if they're not excluded
        if (!excludedProperties.contains("id")) allProperties.put("id", id);
        if (!excludedProperties.contains("name")) allProperties.put("name", name);
        if (!excludedProperties.contains("price")) allProperties.put("price", price); // Fix: Use 'price' instead of 'image'
        if (!excludedProperties.contains("image")) allProperties.put("image", image);
        if (!excludedProperties.contains("out_of_stock")) allProperties.put("out_of_stock", out_of_stock);
        if (!excludedProperties.contains("sell_by_weight")) allProperties.put("sell_by_weight", sell_by_weight);
        if (!excludedProperties.contains("description")) allProperties.put("description", description);
        if (!excludedProperties.contains("category_id")) allProperties.put("category_id", category_id);
        if (!excludedProperties.contains("category_name")) allProperties.put("category_name", category_name);
        if (!excludedProperties.contains("category_type")) allProperties.put("category_type", category_type);
        if (!excludedProperties.contains("unit_type")) allProperties.put("unit_type", unit_type);
        if (!excludedProperties.contains("unit_id")) allProperties.put("unit_id", unit_id);
        if (!excludedProperties.contains("printer_id")) allProperties.put("printer_id", printer_id);
        if (!excludedProperties.contains("children")) allProperties.put("children", children);

        // Add additional properties
        allProperties.putAll(additionalProperties);

        return allProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String key, Object value) {
        this.additionalProperties.put(key, value);
    }

    // Method to exclude properties
    public void excludeProperty(String... propertyNames) {
        excludedProperties.addAll(Arrays.asList(propertyNames));
    }

    // Method to include previously excluded properties
    public void includeProperty(String... propertyNames) {
        excludedProperties.removeAll(Arrays.asList(propertyNames));
    }

    // Override the default serialization
    @JsonValue
    public Map<String, Object> serialize() {
        return getAdditionalProperties();
    }
}
