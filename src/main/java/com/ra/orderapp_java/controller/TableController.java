package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.service.area.AreaService;
import com.ra.orderapp_java.service.table.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/table")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<TableResponseDTO>>> index(
        @RequestParam(name = "area_id",required = false) Long area_id,
        @RequestParam(name = "active",required = false) Boolean active
    ){
        return new ResponseEntity<>(
            GenericResponse.success(tableService.findAll(area_id,active)),
            HttpStatus.OK
        );
    }


    @PostMapping
    public ResponseEntity<GenericResponse<TableResponseDTO>> create(@RequestBody TableRequestDTO dto){

        return new ResponseEntity<>(
            GenericResponse.success(tableService.create(null,dto)),
            HttpStatus.CREATED
        );
    }

    @PostMapping("/batch-create")
    public ResponseEntity<GenericResponse<List<TableResponseDTO>>> batchCreate(@RequestBody BatchCreateTableDto dto){
        return new ResponseEntity<>(
            GenericResponse.success(tableService.batchCreate(dto)),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<TableResponseDTO>> findById(@PathVariable long id){
        TableResponseDTO dto = tableService.findById(id);

        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<TableResponseDTO>> update(@PathVariable Long id, @RequestBody TableRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(tableService.create(id,dto)),
            HttpStatus.CREATED
        );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        tableService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
