package com.ra.orderapp_java.controller;


import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<CategoryResponseDTO>>> index(
        @RequestParam(name = "active",required = false) Boolean active,
        @RequestParam(name = "type",required = false) Integer type
    ){
        CATEGORY_TYPE category_type = null;
        if (type != null){
            category_type = CATEGORY_TYPE.fromValue(type);
        }

        List<CategoryResponseDTO> list = new ArrayList<>();

        for (Category category: categoryService.findAll(active,category_type)) {
            list.add(new CategoryResponseDTO(category));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper<CategoryResponseDTO>> create(@RequestBody CategoryRequestDTO dto) throws CustomException {
        CategoryResponseDTO result = new CategoryResponseDTO(categoryService.create(null,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<CategoryResponseDTO>> findById(@PathVariable long id) throws CustomException {
        CategoryResponseDTO dto = new CategoryResponseDTO(categoryService.findById(id));
        return new ResponseEntity<>(
            ResponseWrapper.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }
//    @CrossOrigin()
    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<CategoryResponseDTO>> update(@PathVariable Long id, @RequestBody CategoryRequestDTO dto) throws CustomException {
        CategoryResponseDTO result = new CategoryResponseDTO(categoryService.create(id,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
