package com.ra.orderapp_java.service.printer;

import com.ra.orderapp_java.model.dto.area.AreaResponseDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.model.dto.table.TableResponseDTO;
import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.Printer;
import com.ra.orderapp_java.model.entity.TableEntity;
import com.ra.orderapp_java.repository.AreaRepository;
import com.ra.orderapp_java.repository.PrinterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrinterServiceImpl implements PrinterService{
    public final PrinterRepository printerRepo;

    public PrinterServiceImpl(PrinterRepository printerRepo) {
        this.printerRepo = printerRepo;
    }


    @Override
    public List<PrinterResponseDTO> findAll() {

        List<PrinterResponseDTO> list = new ArrayList();
        for(Printer printer : printerRepo.findAll()) {
            list.add(new PrinterResponseDTO(printer));
        }
        return list;
    }

    @Override
    public PrinterResponseDTO create(Long id,PrinterRequestDTO dto) {
        Printer printer = printerRepo.save(Printer.builder()
                .id(id)
                .name(dto.getName())
                .printer_name(dto.getPrinter_name())
                .ip_address(dto.getIp_address())
                .port(dto.getPort())
                .connection_type(dto.getConnection_type())
                .print_number(dto.getPrint_number())
                .is_print_each_paper(dto.getIs_print_each_paper())
                .is_active(dto.getIs_active())
                .type(dto.getType())
                .build());
        return new PrinterResponseDTO(printer);
    }

    @Override
    public PrinterResponseDTO findById(Long id) {
        Printer printer = printerRepo.findById(id).orElse(null);
        return printer == null ? null : new PrinterResponseDTO(printer);
    }

    @Override
    public void delete(long id) {
        printerRepo.deleteById(id);
    }
}
