package com.ra.orderapp_java.model.dto.area;

import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AreaRequestDTO {
    private String name;
    private Boolean active;
}
