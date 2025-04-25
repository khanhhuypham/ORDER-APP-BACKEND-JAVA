package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.service.childrenItem.ChildrenItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/children-item")
public class ChildrenItemController {
    private final ChildrenItemService childrenItemService;

    public ChildrenItemController(ChildrenItemService childrenItemService) {
        this.childrenItemService = childrenItemService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<ChildrenItemResponseDTO>>> index() {
        List<ChildrenItemResponseDTO> list = new ArrayList<>();

        for (ChildrenItem child : childrenItemService.findAll()) {
            list.add(new ChildrenItemResponseDTO(child));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<ChildrenItemResponseDTO>> findById(@PathVariable Long id) throws CustomException {
        ChildrenItemResponseDTO dto = new ChildrenItemResponseDTO(childrenItemService.findById(id));
        return new ResponseEntity<>(ResponseWrapper.success(dto), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseWrapper<ChildrenItemResponseDTO>> create(@RequestBody ChildrenItemRequestDTO dto) throws CustomException {
        ChildrenItemResponseDTO result = new ChildrenItemResponseDTO(childrenItemService.create(null, dto));

        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<ChildrenItemResponseDTO>> update(@PathVariable Long id, @RequestBody ChildrenItemRequestDTO dto) throws CustomException {
        ChildrenItemResponseDTO result = new ChildrenItemResponseDTO(childrenItemService.create(id, dto));

        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        childrenItemService.delete(id);
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }

}