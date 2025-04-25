package com.ra.orderapp_java.service.category;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll(Boolean active, CATEGORY_TYPE type);
    Category create(Long id,CategoryRequestDTO dto) throws CustomException;
    Category findById(Long id) throws CustomException;
    void delete(long id);
}
