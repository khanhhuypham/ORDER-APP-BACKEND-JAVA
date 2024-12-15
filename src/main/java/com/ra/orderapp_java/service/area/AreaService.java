package com.ra.orderapp_java.service.area;

import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AreaService {
    List<AreaResponseDTO> findAll(Boolean active);
    AreaResponseDTO create(Long id,AreaRequestDTO dto);
    AreaResponseDTO findById(Long id);
    void delete(long id);
}
