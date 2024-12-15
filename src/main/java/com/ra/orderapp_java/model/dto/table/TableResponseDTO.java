package com.ra.orderapp_java.model.dto.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ra.orderapp_java.model.constant.TABLE_STATUS;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.TableEntity;
import lombok.*;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TableResponseDTO {
    private Long id;
    private String name;
    private Integer status;
    private Boolean active;
    private Long area_id;
    private Long total_slot;

    public TableResponseDTO(TableEntity table) {
        this.id = table.getId();
        this.name = table.getName();
        if (table.getStatus() != null){
            this.status = table.getStatus().getValue();
        }
        this.active = table.getActive();
        this.area_id = table.getArea().getId();
        this.total_slot = table.getTotal_slot();
    }


}

