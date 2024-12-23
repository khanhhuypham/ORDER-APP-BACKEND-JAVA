package com.ra.orderapp_java.service.category;

import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll(Boolean active, CATEGORY_TYPE type);
    CategoryResponseDTO create(Long id,CategoryRequestDTO dto);
    CategoryResponseDTO findById(Long id);
    void delete(long id);
}
