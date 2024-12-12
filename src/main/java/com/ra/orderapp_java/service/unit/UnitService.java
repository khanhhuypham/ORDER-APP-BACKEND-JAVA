package com.ra.orderapp_java.service.unit;

import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;

import java.util.List;

public interface UnitService {
    List<UnitResponseDTO> findAll();
    UnitResponseDTO create(Long id, UnitRequestDTO dto);
    UnitResponseDTO findById(Long id);
    void delete(long id);
}
