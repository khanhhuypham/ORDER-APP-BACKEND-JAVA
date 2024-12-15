package com.ra.orderapp_java.model.dto.category;


import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequestDTO {
    private String name;
    private Boolean active;
    private String description;
    private CATEGORY_TYPE type;

}
