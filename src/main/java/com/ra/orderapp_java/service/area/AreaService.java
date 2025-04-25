package com.ra.orderapp_java.service.area;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AreaService {
    List<Area> findAll(Boolean active) throws CustomException;
    Area create(Long id,AreaRequestDTO dto) throws CustomException;
    Area findById(Long id) throws CustomException;
    void delete(long id) throws CustomException;
}
