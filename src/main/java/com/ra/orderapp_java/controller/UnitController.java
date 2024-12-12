package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.dto.unit.UnitRequestDTO;
import com.ra.orderapp_java.model.dto.unit.UnitResponseDTO;
import com.ra.orderapp_java.service.table.TableService;
import com.ra.orderapp_java.service.unit.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/unit")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<UnitResponseDTO>> index(){
        return new ResponseEntity<>(unitService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UnitResponseDTO> create(@RequestBody UnitRequestDTO dto){
        return new ResponseEntity<>(unitService.create(null,dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        UnitResponseDTO dto = unitService.findById(id);

        return dto == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(unitService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitResponseDTO> update(@PathVariable Long id, @RequestBody UnitRequestDTO dto){

        return new ResponseEntity<>(unitService.create(id,dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        unitService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
