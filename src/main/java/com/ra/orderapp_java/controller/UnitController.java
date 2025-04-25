package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;
import com.ra.orderapp_java.model.entity.Unit;
import com.ra.orderapp_java.service.unit.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/unit")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<UnitResponseDTO>>> index(){
        List<UnitResponseDTO> list = new ArrayList();
        for(Unit unit : unitService.findAll()) {
            list.add(new UnitResponseDTO(unit));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper<UnitResponseDTO>> create(@RequestBody UnitRequestDTO dto) throws CustomException {
        UnitResponseDTO result =  new UnitResponseDTO(unitService.create(null,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<UnitResponseDTO>> findById(@PathVariable long id) throws CustomException {
        UnitResponseDTO dto =  new UnitResponseDTO(unitService.findById(id));
        return new ResponseEntity<>(ResponseWrapper.success(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<UnitResponseDTO>> update(@PathVariable Long id, @RequestBody UnitRequestDTO dto) throws CustomException {
        UnitResponseDTO result =  new UnitResponseDTO(unitService.create(id,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws CustomException {
        unitService.delete(id);
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }
}
