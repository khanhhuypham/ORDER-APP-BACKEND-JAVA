package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.category.CategoryRequestDTO;
import com.ra.orderapp_java.model.dto.category.CategoryResponseDTO;
import com.ra.orderapp_java.service.area.AreaService;
import com.ra.orderapp_java.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<List<AreaResponseDTO>> index(){
        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AreaResponseDTO> create(@RequestBody AreaRequestDTO dto){
        return new ResponseEntity<>(areaService.create(null,dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        AreaResponseDTO dto = areaService.findById(id);
        return dto == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(areaService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> update(@PathVariable Long id, @RequestBody AreaRequestDTO dto){

        return new ResponseEntity<>(areaService.create(id,dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
