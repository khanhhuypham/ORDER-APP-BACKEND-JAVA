package com.ra.orderapp_java.service.printer;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.model.entity.Printer;
import com.ra.orderapp_java.repository.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PrinterServiceImpl implements PrinterService{
    private final PrinterRepository printerRepo;


    @Override
    public List<Printer> findAll() {
        return printerRepo.findAll();
    }

    @Override
    public Printer create(Long id,PrinterRequestDTO dto) {
        return printerRepo.save(Printer.builder()
            .id(id)
            .name(dto.getName())
            .printer_name(dto.getPrinter_name())
            .ip_address(dto.getIp_address())
            .port(dto.getPort())
            .connection_type(dto.getConnection_type())
            .print_number(dto.getNumber_of_copies())
            .is_print_each_paper(dto.getIs_print_each_paper())
            .active(dto.getActive())
            .type(dto.getType())
            .build());
    }

    @Override
    public Printer findById(Long id) throws CustomException {
        Printer printer = printerRepo.findById(id).orElse(null);
        if (printer == null){
            throw new CustomException("Printer not found", HttpStatus.NOT_FOUND);
        }

        return printer;
    }

    @Override
    public void delete(long id) {
        printerRepo.deleteById(id);
    }
}
