package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;

import com.ra.orderapp_java.model.entity.Printer;
import com.ra.orderapp_java.service.printer.PrinterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/printer")
public class PrinterController {

    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper<List<PrinterResponseDTO>>> index(){

        List<PrinterResponseDTO> list = new ArrayList();

        for(Printer printer : printerService.findAll()) {
            list.add(new PrinterResponseDTO(printer));
        }

        return new ResponseEntity<>(ResponseWrapper.success(list), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<PrinterResponseDTO>> create(@RequestBody PrinterRequestDTO dto){
        PrinterResponseDTO result = new PrinterResponseDTO(printerService.create(null,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<PrinterResponseDTO>> findById(@PathVariable long id) throws CustomException {
        PrinterResponseDTO dto = new PrinterResponseDTO(printerService.findById(id));
        return new ResponseEntity<>(ResponseWrapper.success(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<PrinterResponseDTO>> update(@PathVariable Long id, @RequestBody PrinterRequestDTO dto){
        PrinterResponseDTO result = new PrinterResponseDTO(printerService.create(id,dto));
        return new ResponseEntity<>(ResponseWrapper.success(result),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        printerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
