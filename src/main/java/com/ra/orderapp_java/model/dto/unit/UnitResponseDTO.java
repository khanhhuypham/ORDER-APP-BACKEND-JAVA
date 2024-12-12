package com.ra.orderapp_java.model.dto.unit;


import com.ra.orderapp_java.model.entity.Unit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UnitResponseDTO {
    private Long id;
    private String name;

    public UnitResponseDTO(Unit unit) {
        this.id = unit.getId();
        this.name = unit.getName();
    }
}
