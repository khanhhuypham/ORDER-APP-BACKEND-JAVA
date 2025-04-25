package com.ra.orderapp_java.service.printer;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.model.entity.Printer;

import java.util.List;

public interface PrinterService {
    List<Printer> findAll();
    Printer create(Long id,PrinterRequestDTO dto);
    Printer findById(Long id) throws CustomException;
    void delete(long id);
}
