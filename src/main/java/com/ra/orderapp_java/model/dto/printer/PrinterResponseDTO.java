package com.ra.orderapp_java.model.dto.printer;

import com.ra.orderapp_java.model.constant.PRINTER_TYPE;
import com.ra.orderapp_java.model.entity.Printer;
import com.ra.orderapp_java.model.entity.TableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PrinterResponseDTO {
    private Long id;
    private String name;
    private String printer_name;
    private String ip_address;
    private Integer port;
    private Integer connection_type;
    private Integer print_number;
    private Boolean is_print_each_paper;
    private Boolean is_active;
    private PRINTER_TYPE type;

    public PrinterResponseDTO(Printer printer) {
        this.id = printer.getId();
        this.name = printer.getName();
        this.printer_name = printer.getPrinter_name();
        this.ip_address = printer.getIp_address();
        this.port = printer.getPort();
        this.connection_type = printer.getConnection_type();
        this.print_number = printer.getPrint_number();
        this.is_print_each_paper = printer.getIs_print_each_paper();
        this.is_active = printer.getIs_active();
        this.type = printer.getType();
    }
}
