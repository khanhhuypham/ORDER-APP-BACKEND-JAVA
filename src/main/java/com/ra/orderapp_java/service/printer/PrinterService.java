package com.ra.orderapp_java.service.printer;

import com.ra.orderapp_java.model.dto.food.FoodRequestDTO;
import com.ra.orderapp_java.model.dto.food.FoodResponseDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PrinterService {
    List<PrinterResponseDTO> findAll();
    PrinterResponseDTO create(Long id,PrinterRequestDTO dto);
    PrinterResponseDTO findById(Long id);
    void delete(long id);
}
