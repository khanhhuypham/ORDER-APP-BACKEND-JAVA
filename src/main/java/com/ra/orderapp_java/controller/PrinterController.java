package com.ra.orderapp_java.controller;

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
    public ResponseEntity<List<PrinterResponseDTO>> index(){
        return new ResponseEntity<>(printerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PrinterResponseDTO> create(@RequestBody PrinterRequestDTO dto){
        return new ResponseEntity<>(printerService.create(null,dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        PrinterResponseDTO dto = printerService.findById(id);

        return dto == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(printerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrinterResponseDTO> update(@PathVariable Long id, @RequestBody PrinterRequestDTO dto){

        return new ResponseEntity<>(printerService.create(id,dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        printerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
