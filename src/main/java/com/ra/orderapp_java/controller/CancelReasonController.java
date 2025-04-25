package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonRequestDTO;
import com.ra.orderapp_java.model.dto.cancelReason.CancelReasonResponseDTO;
import com.ra.orderapp_java.service.cancelReason.CancelReasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cancel-reason")
public class CancelReasonController {

    private final CancelReasonService cancelReasonService;

    public CancelReasonController(CancelReasonService cancelReasonService) {
        this.cancelReasonService = cancelReasonService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<CancelReasonResponseDTO>>> index(){

        return new ResponseEntity<>(
                ResponseWrapper.success(cancelReasonService.findAll()),
                HttpStatus.OK
        );
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper<CancelReasonResponseDTO>> create(@RequestBody CancelReasonRequestDTO dto){
        return new ResponseEntity<>(
                ResponseWrapper.success(cancelReasonService.create(null,dto)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<CancelReasonResponseDTO>> findById(@PathVariable long id){
        CancelReasonResponseDTO dto = cancelReasonService.findById(id);
        return new ResponseEntity<>(
                ResponseWrapper.success(dto),
                dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );
    }
    //    @CrossOrigin()
    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<CancelReasonResponseDTO>> update(@PathVariable Long id, @RequestBody CancelReasonRequestDTO dto){
        return new ResponseEntity<>(
                ResponseWrapper.success(cancelReasonService.create(id,dto)),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        cancelReasonService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
