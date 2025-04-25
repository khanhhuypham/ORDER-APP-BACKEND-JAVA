package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.service.area.AreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<AreaResponseDTO>>> index(
        @RequestParam(value = "active",required = false) Boolean active
    ) throws CustomException {
        List<AreaResponseDTO> list = new ArrayList<>();

        for(Area area : areaService.findAll(active)){
            list.add(new AreaResponseDTO(area));
        }

        return new ResponseEntity<>(
            ResponseWrapper.success(list),
            HttpStatus.OK
        );
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper<AreaResponseDTO>> create(@RequestBody AreaRequestDTO dto) throws CustomException {

        AreaResponseDTO result = new AreaResponseDTO(areaService.create(null,dto));

        return new ResponseEntity<>(
            ResponseWrapper.success(result),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) throws CustomException {
        AreaResponseDTO dto = new AreaResponseDTO(areaService.findById(id));

        return new ResponseEntity<>(
            ResponseWrapper.success(dto),HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<AreaResponseDTO>> update(@PathVariable Long id, @RequestBody AreaRequestDTO dto) throws CustomException {

        AreaResponseDTO result = new AreaResponseDTO(areaService.create(id,dto));

        return new ResponseEntity<>(
            ResponseWrapper.success(result),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws CustomException {
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
