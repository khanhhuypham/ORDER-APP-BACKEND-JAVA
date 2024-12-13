package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.service.childrenItem.ChildrenItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/children-item")
public class ChildrenItemController {
    private final ChildrenItemService childrenItemService;

    public ChildrenItemController(ChildrenItemService childrenItemService) {
        this.childrenItemService = childrenItemService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<ChildrenItemResponseDTO>>> index(){
        return new ResponseEntity<>(
            GenericResponse.success(childrenItemService.findAll()),
            HttpStatus.OK
        );
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword){
//        List<ChildrenItemResponseDTO> responseDTOS = childrenItemService.searchByFoodName(keyword);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ChildrenItemResponseDTO>> findById(@PathVariable Long id){
        ChildrenItemResponseDTO dto = childrenItemService.findById(id);
        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<GenericResponse<ChildrenItemResponseDTO>> create(@RequestBody ChildrenItemRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(childrenItemService.create(null,dto)),
            HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ChildrenItemResponseDTO>> update(@PathVariable Long id,@RequestBody ChildrenItemRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(childrenItemService.create(id,dto)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        childrenItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
