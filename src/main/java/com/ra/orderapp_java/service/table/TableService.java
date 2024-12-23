package com.ra.orderapp_java.service.table;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;


import java.util.List;

public interface TableService{
    List<TableResponseDTO> findAll(Long areaId,Boolean active);
    TableResponseDTO create(Long id,TableRequestDTO dto);
    List<TableResponseDTO> batchCreate(BatchCreateTableDto dto);
    TableResponseDTO findById(Long id);
    void delete(long id);
}
