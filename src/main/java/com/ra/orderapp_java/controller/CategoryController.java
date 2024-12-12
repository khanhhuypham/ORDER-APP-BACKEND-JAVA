package com.ra.orderapp_java.controller;


import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
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
    public ResponseEntity<List<CategoryResponseDTO>> index(@RequestParam(defaultValue = "-1",name = "status") int status){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<?> index(
//            @RequestParam(defaultValue = "0",name = "page") int page,
//            @RequestParam(defaultValue = "3",name = "limit") int limit
//    ){
//        Pageable pageable = PageRequest.of(page,limit);
//        Page<CategoryResponseDTO> pageObj = categoryService.paginate(pageable);
//        return new ResponseEntity<>(pageObj, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO dto){
        return new ResponseEntity<>(categoryService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        CategoryResponseDTO dto = categoryService.findById(id);
        return dto == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryRequestDTO dto){
        dto.setId(id);
        return new ResponseEntity<>(categoryService.create(dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
