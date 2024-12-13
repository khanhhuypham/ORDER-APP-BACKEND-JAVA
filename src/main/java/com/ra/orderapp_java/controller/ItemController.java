package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.food.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.food.ItemResponseDTO;

import com.ra.orderapp_java.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<ItemResponseDTO>>> index(){
        return new ResponseEntity<>(
            GenericResponse.success(itemService.findAll()),
            HttpStatus.OK
        );
    }

//    @GetMapping("/search")
//    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword){
//        List<FoodResponseDTO> responseDTOS = itemService.searchByFoodName(keyword);
//        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<?> index(
//            @RequestParam(defaultValue = "0",name = "page") int page,
//            @RequestParam(defaultValue = "3",name = "limit") int limit,
//            @RequestParam(defaultValue = "",name = "search_key") String search_key
//    ){
//        Pageable pageable = PageRequest.of(page,limit);
//        Page<ProductResponseDTO> pageObj = productService.pagination(pageable,search_key);
//        return new ResponseEntity<>(pageObj,HttpStatus.OK);
//    }

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
