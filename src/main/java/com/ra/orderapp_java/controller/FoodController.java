package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.food.FoodRequestDTO;
import com.ra.orderapp_java.model.dto.food.FoodResponseDTO;
import com.ra.orderapp_java.service.food.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/foods")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> index(){
        return new ResponseEntity<>(foodService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword){
        List<FoodResponseDTO> responseDTOS = foodService.searchByFoodName(keyword);
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }

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
    public ResponseEntity<FoodResponseDTO> findById(@PathVariable Long id){
        FoodResponseDTO dto = foodService.findById(id);

        return dto == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<FoodResponseDTO> create(@RequestBody FoodRequestDTO dto){

        return new ResponseEntity<>(foodService.create(dto),HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodResponseDTO> update(@PathVariable Long id,@RequestBody FoodRequestDTO dto){
        dto.setId(id);
        System.out.println(dto.getName());
        return new ResponseEntity<>(foodService.create(dto),HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        foodService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
