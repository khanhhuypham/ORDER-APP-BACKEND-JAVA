package com.ra.orderapp_java.model.dto.category;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequestDTO {
    private Long id;
    private String name;
    private Boolean active;
    private String description;
}
