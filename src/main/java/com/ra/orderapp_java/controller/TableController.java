package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.area.AreaRequestDTO;
import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.service.area.AreaService;
import com.ra.orderapp_java.service.table.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/table")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public ResponseEntity<List<TableResponseDTO>> index(@RequestParam(defaultValue = "-1",name = "area_id") int area_id){
        return new ResponseEntity<>(tableService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<TableResponseDTO> create(@RequestBody TableRequestDTO dto){
        System.out.println(dto.toString());
        return new ResponseEntity<>(tableService.create(null,dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        TableResponseDTO dto = tableService.findById(id);

        return dto == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(tableService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableResponseDTO> update(@PathVariable Long id, @RequestBody TableRequestDTO dto){
        return new ResponseEntity<>(tableService.create(id,dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        tableService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
