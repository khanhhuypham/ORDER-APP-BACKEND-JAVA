package com.ra.orderapp_java.service.category;


import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepo;

    public CategoryServiceImp(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<CategoryResponseDTO> findAll() {
        List<CategoryResponseDTO> list = new ArrayList<>();

        for (Category category: categoryRepo.findAll()) {
            list.add(new CategoryResponseDTO(category));
        }

        return list;
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category categorySaved = categoryRepo.save(
                Category.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .active(dto.getActive())
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
