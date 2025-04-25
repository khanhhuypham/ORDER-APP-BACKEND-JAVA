package com.ra.orderapp_java.service.unit;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;
import com.ra.orderapp_java.model.entity.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> findAll();
    Unit create(Long id, UnitRequestDTO dto) throws CustomException;
    Unit findById(Long id) throws CustomException;
    void delete(long id) throws CustomException;
}
