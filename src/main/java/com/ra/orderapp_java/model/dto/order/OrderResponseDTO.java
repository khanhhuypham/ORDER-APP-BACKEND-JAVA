package com.ra.orderapp_java.model.dto.order;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;
import lombok.*;

import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponseDTO {
    private Long id;
    private Integer status;
    private Integer type;
    private String using_time;
    private Integer using_slot;

    private Double net_amount;
    private Integer booking_status;

    private Long user_id;

    private Long table_id;
    private String table_name;
    private String table_merged_names;

    private List<ItemResponseDTO> items;

    public OrderResponseDTO(Order order) {
        this.id = order.getId();
        this.status = (order.getStatus() != null) ? order.getStatus().getValue() : null;
        this.type = (order.getType() != null) ? order.getType().getValue() : null;
        this.using_time = order.getUsing_time();
        this.using_slot = order.getUsing_slot();
        this.net_amount = (order.getPayment() != null) ? order.getPayment().getNet_amount() : null;
        this.user_id = (order.getUser() != null) ? order.getUser().getId() : null;
        if (order.getTable() != null) {
            this.table_id = order.getTable().getId();
            this.table_name = order.getTable().getName();
        }
    }

    public OrderResponseDTO(Order order, List<ItemResponseDTO> items) {
        this(order);
        this.items = items; //Set the additional items field
    }

    public void filterPropertiesForOrDetailDTO() {
        this.excludeProperty(
                "table_merged_names",
                "using_slot",
                "using_time",
                "booking_status"
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
        if (!excludedProperties.contains("status")) allProperties.put("status", status);
        if (!excludedProperties.contains("type")) allProperties.put("type", type);
        if (!excludedProperties.contains("using_time")) allProperties.put("using_time", using_time);
        if (!excludedProperties.contains("using_slot")) allProperties.put("using_slot", using_slot);
        if (!excludedProperties.contains("net_amount")) allProperties.put("net_amount", net_amount);
        if (!excludedProperties.contains("booking_status")) allProperties.put("booking_status", booking_status);
        if (!excludedProperties.contains("user_id")) allProperties.put("user_id", user_id);
        if (!excludedProperties.contains("table_id")) allProperties.put("table_id", table_id);
        if (!excludedProperties.contains("table_name")) allProperties.put("table_name", table_name);
        if (!excludedProperties.contains("table_merged_names")) allProperties.put("table_merged_names", table_merged_names);
        if (!excludedProperties.contains("items")) allProperties.put("items", items);
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
