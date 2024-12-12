package com.ra.orderapp_java.service.table;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;


import java.util.List;

public interface TableService{
    List<TableResponseDTO> findAll();
    TableResponseDTO create(Long id,TableRequestDTO dto);
    TableResponseDTO findById(Long id);
    void delete(long id);
}
