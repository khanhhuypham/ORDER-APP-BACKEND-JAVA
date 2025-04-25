package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.table.BatchCreateTableDto;
import com.ra.orderapp_java.model.dto.table.TableRequestDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.service.table.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/v1/table")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<TableResponseDTO>>> index(@RequestParam(name = "area_id", required = false) Long area_id, @RequestParam(name = "active", required = false) Boolean active) {
        List<TableResponseDTO> list = new ArrayList<TableResponseDTO>();
        List<TableEntity> tables = tableService.findAllByCondition(area_id, active);

        for (TableEntity table : tables) {
            list.add(new TableResponseDTO(table));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }

    @GetMapping("/management")
    public ResponseEntity<ResponseWrapper<List<TableResponseDTO>>> findAll(@RequestParam(name = "area_id", required = false) Long area_id) {

        List<TableResponseDTO> list = new ArrayList<TableResponseDTO>();

        for (TableEntity table : tableService.findAllForManagement(area_id)) {
            TableResponseDTO dto = new TableResponseDTO(table);
            dto.setOrder(null);
            list.add(dto);
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }

    @GetMapping("/move-table")
    public ResponseEntity<ResponseWrapper<?>> moveTable(@RequestParam(name = "from") Long fromId, @RequestParam(name = "to") Long toId) throws Exception {
        tableService.moveTable(fromId, toId);
        return new ResponseEntity<>(ResponseWrapper.success("Chuyển bàn thành công"), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper<TableResponseDTO>> create(@RequestBody TableRequestDTO dto) throws CustomException {
        TableResponseDTO result = new TableResponseDTO(tableService.create(null, dto));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @PostMapping("/batch-create")
    public ResponseEntity<ResponseWrapper<List<TableResponseDTO>>> batchCreate(@RequestBody BatchCreateTableDto dto) {

//        return new ResponseEntity<>(
//            GenericResponse.success(tableService.batchCreate(dto)),
//            HttpStatus.CREATED
//        );

        return new ResponseEntity<>(ResponseWrapper.success(null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<TableResponseDTO>> findById(@PathVariable long id) throws CustomException {
        TableResponseDTO dto = new TableResponseDTO(tableService.findById(id));
        return new ResponseEntity<>(ResponseWrapper.success(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<TableResponseDTO>> update(@PathVariable Long id, @RequestBody TableRequestDTO dto) throws CustomException {
        TableResponseDTO result = new TableResponseDTO(tableService.create(id, dto));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @GetMapping("/merge")
    public ResponseEntity<?> mergeTable(@RequestParam(name = "destination_table_id") Long destination_table_id, @RequestParam(name = "target_table_id") List<Long> target_table_id) throws CustomException {
        TableResponseDTO result = new TableResponseDTO(tableService.mergeTable(destination_table_id, target_table_id));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        tableService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
