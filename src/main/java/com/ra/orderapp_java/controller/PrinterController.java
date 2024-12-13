package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.GenericResponse;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;

import com.ra.orderapp_java.service.printer.PrinterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/printer")
public class PrinterController {

    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }


    @GetMapping
    public ResponseEntity<GenericResponse<List<PrinterResponseDTO>>> index(){
        return new ResponseEntity<>(GenericResponse.success(printerService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<PrinterResponseDTO>> create(@RequestBody PrinterRequestDTO dto){
        return new ResponseEntity<>(GenericResponse.success(printerService.create(null,dto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<PrinterResponseDTO>> findById(@PathVariable long id){
        PrinterResponseDTO dto = printerService.findById(id);

        return new ResponseEntity<>(
            GenericResponse.success(dto),
            dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<PrinterResponseDTO>> update(@PathVariable Long id, @RequestBody PrinterRequestDTO dto){
        return new ResponseEntity<>(
            GenericResponse.success(printerService.create(id,dto)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        printerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
