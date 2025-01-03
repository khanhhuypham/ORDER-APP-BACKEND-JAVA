package com.ra.orderapp_java.service.category;


import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepo;

    @Override
    public List<CategoryResponseDTO> findAll(Boolean active, CATEGORY_TYPE type){
        List<CategoryResponseDTO> list = new ArrayList<>();

        for (Category category: categoryRepo.findAllByCondition(active,type)) {
            list.add(new CategoryResponseDTO(category));
        }
        return list;
    }

    @Override
    public CategoryResponseDTO create(Long id,CategoryRequestDTO dto) {
        Category categorySaved = categoryRepo.save(
            Category.builder()
                .id(id)
                .name(dto.getName())
                .active(dto.getActive())
                .type(dto.getType())
                .build()
        );

        return new CategoryResponseDTO(categorySaved);
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepo.findById(id).orElse(null);

        return category == null ? null : new CategoryResponseDTO(category);
    }

    @Override
    public void delete(long id) {
        categoryRepo.deleteById(id);
    }


}
