package com.ra.orderapp_java.model.dto.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AreaResponseDTO {
    private Long id;
    private String name;
    private Boolean active;

//    private List<TableResponseDTO> tables;

    public AreaResponseDTO(Area area) {
        this.id = area.getId();
        this.name = area.getName();
        this.active = area.getActive();
//        this.tables = area.getTables().stream()
//                .map(TableResponseDTO::new)
//                .collect(Collectors.toList());
    }


}

