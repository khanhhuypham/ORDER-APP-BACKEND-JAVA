package com.ra.orderapp_java.controller;


import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.service.category.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<CategoryResponseDTO>>> index(
        @RequestParam(name = "active",required = false) Boolean active,
        @RequestParam(name = "type",required = false) Integer type
    ){
        CATEGORY_TYPE category = null;
        if (type != null){
            category = CATEGORY_TYPE.fromValue(type);
        }

        return new ResponseEntity<>(
            GenericResponse.success(categoryService.findAll(active,category)),
            HttpStatus.OK
        );
    }


    @PostMapping
    public ResponseEntity<GenericResponse<CategoryResponseDTO>> create(@RequestBody CategoryRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(categoryService.create(null,dto)),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CategoryResponseDTO>> findById(@PathVariable long id){
        CategoryResponseDTO dto = categoryService.findById(id);
        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }
//    @CrossOrigin()
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CategoryResponseDTO>> update(@PathVariable Long id, @RequestBody CategoryRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(categoryService.create(id,dto)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
