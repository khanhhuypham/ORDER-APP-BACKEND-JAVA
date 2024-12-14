package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.food.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.food.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.food.ItemResponseDTO;

import com.ra.orderapp_java.service.item.ItemService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<PaginationDTO<ItemResponseDTO>>> index(@ModelAttribute ItemQueryDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(
                itemService.findAll(dto)
            ),
            HttpStatus.OK
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ItemResponseDTO>> findById(@PathVariable Long id){
        ItemResponseDTO dto = itemService.findById(id);
        return new ResponseEntity<>(
                GenericResponse.success(dto),
                dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<GenericResponse<ItemResponseDTO>> create(@RequestBody ItemRequestDTO dto){

        return new ResponseEntity<>(
            GenericResponse.success(itemService.create(null,dto)),
            HttpStatus.CREATED
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ItemResponseDTO>> update(@PathVariable Long id, @RequestBody ItemRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(itemService.create(id,dto)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
