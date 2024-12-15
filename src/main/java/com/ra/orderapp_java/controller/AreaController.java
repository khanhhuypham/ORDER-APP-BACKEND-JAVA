package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<AreaResponseDTO>>> index(
        @RequestParam(value = "active",required = false) Boolean active
    ){
        System.out.println(active);
        return new ResponseEntity<>(
            GenericResponse.success(areaService.findAll(active)),
            HttpStatus.OK
        );
    }


    @PostMapping
    public ResponseEntity<GenericResponse<AreaResponseDTO>> create(@RequestBody AreaRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(areaService.create(null,dto)),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        AreaResponseDTO dto = areaService.findById(id);

        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AreaResponseDTO>> update(@PathVariable Long id, @RequestBody AreaRequestDTO dto){
        System.out.println(dto.getActive());
        return new ResponseEntity<>(
            GenericResponse.success(areaService.create(id,dto)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
