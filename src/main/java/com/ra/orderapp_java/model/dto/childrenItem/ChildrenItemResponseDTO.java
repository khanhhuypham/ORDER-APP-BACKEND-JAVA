package com.ra.orderapp_java.model.dto.childrenItem;

import com.fasterxml.jackson.annotation.*;
import com.ra.orderapp_java.model.entity.*;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildrenItemResponseDTO {
    private Long id;
    private String name;
    private String image;
    private Double price;
    private Long category_id;
    private String unit_type;
    private String description;
    private Float quantity;

    public ChildrenItemResponseDTO(ChildrenItem childrenItem,Float quantity) {
        this.id = childrenItem.getId();
        this.name = childrenItem.getName();
        this.price = childrenItem.getPrice();
        this.image = childrenItem.getImage();
        this.description = childrenItem.getDescription();
        this.category_id = childrenItem.getCategory().getId();
        this.unit_type = childrenItem.getUnit().getName();
        this.quantity = quantity;
        this.additionalProperties = new HashMap<>();
        this.excludedProperties = new HashSet<>();
    }

    // Constructor without quantity (default quantity is null)
    public ChildrenItemResponseDTO(ChildrenItem childrenItem) {
        this(childrenItem, null); // Delegate to the main constructor
    }

    public void convertToModelForOrder() {
        this.excludeProperty("image","description");
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
        if (!excludedProperties.contains("description")) allProperties.put("description", description);
        if (!excludedProperties.contains("category_id")) allProperties.put("category_id", category_id);
        if (!excludedProperties.contains("unit_type")) allProperties.put("unit_type", unit_type);
        if (!excludedProperties.contains("quantity")) allProperties.put("quantity", quantity);

        // Add additional properties
        allProperties.putAll(additionalProperties);

        return allProperties;
    }

    public void filterPropertiesForOrDetailDTO() {
        this.excludeProperty(
            "description",
            "category_id",
            "unit_type",
            "image"
        );
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