package com.ra.orderapp_java.service.category;


import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepo;

    @Override
    public List<Category> findAll(Boolean active, CATEGORY_TYPE type){

        return categoryRepo.findAllByCondition(active,type);
    }

    @Override
    public Category create(Long id,CategoryRequestDTO dto) throws CustomException{

        return categoryRepo.save(
            Category.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .type(dto.getType())
                .build()
        );
    }

    @Override
    public Category findById(Long id) throws CustomException {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category == null){
            throw new CustomException("Category not found", HttpStatus.NOT_FOUND);
        }
        return category;
    }

    @Override
    public void delete(long id) {
        categoryRepo.deleteById(id);
    }


}
