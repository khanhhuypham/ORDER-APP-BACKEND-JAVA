package com.ra.orderapp_java.model.dto.table;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BatchCreateTableDto {
    private Long branch_id;
    private ArrayList<TableRequestDTO> tables;
}
