package com.ra.orderapp_java;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;


public class ChildrenItemResponseDTOTest {

//    private final ObjectMapper mapper = new ObjectMapper();
//
//    @Test
//    void testDynamicSerialization() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Create DTO
//        ChildrenItemResponseDTO dto = ChildrenItemResponseDTO.builder()
//                .id(1L)
//                .name("Test Item")
//                .image("test.jpg")
//                .price(10.99)
//                .category_id(1L)
//                .unit_type("piece")
//                .description("Test description")
//                .build();
//
//        // Test 1: Exclude image and add additional property
//        dto.excludeProperty("image");
//        dto.setAdditionalProperty("status", "active");
//
//        String jsonWithoutImage = objectMapper.writeValueAsString(dto);
//        assertFalse(jsonWithoutImage.contains("image"));
//        assertTrue(jsonWithoutImage.contains("status"));
//
//        // Test 2: Include image back and add different property
//        dto.includeProperty("image");
//        dto.excludeProperty("description");
//        dto.setAdditionalProperty("count", 5);
//
//        String jsonWithImage = objectMapper.writeValueAsString(dto);
//        assertTrue(jsonWithImage.contains("image"));
//        assertFalse(jsonWithImage.contains("description"));
//        assertTrue(jsonWithImage.contains("count"));
//    }
//
//    @Test
//    public void testDeserializationWithDynamicProperties() throws IOException {
//        String json = """
//            {
//                "id": 3,
//                "name": "Third Item",
//                "price": 39.99,
//                "category_id": 1003,
//                "description": "Third sample item.",
//                "color": "Green",
//                "size": "Small",
//                "discount": 15.0,
//                "extraField": "Extra Value"
//            }
//        """;
//
//
//        ChildrenItemResponseDTO dto = mapper.readValue(json, ChildrenItemResponseDTO.class);
//
//        // Verify known properties
//        assertThat(dto.getId()).isEqualTo(3L);
//        assertThat(dto.getName()).isEqualTo("Third Item");
//        assertThat(dto.getPrice()).isEqualTo(39.99);
//        assertThat(dto.getCategory_id()).isEqualTo(1003L);
//        assertThat(dto.getDescription()).isEqualTo("Third sample item.");
//
//        // Verify dynamic properties
//        Map<String, Object> additional = dto.getAdditionalProperties();
//        assertThat(additional).hasSize(4)
//            .containsEntry("color", "Green")
//            .containsEntry("size", "Small")
//            .containsEntry("discount", 15.0)
//            .containsEntry("extraField", "Extra Value");
//    }


}

