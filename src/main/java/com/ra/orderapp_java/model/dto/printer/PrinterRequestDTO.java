package com.ra.orderapp_java.model.dto.printer;


import com.ra.orderapp_java.model.constant.CONNECTION_TYPE;
import com.ra.orderapp_java.model.constant.PRINTER_TYPE;
import com.ra.orderapp_java.model.entity.Printer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PrinterRequestDTO {
    private String name;
    private String printer_name;
    private String ip_address;
    private Integer port;
    private CONNECTION_TYPE connection_type;
    private Integer number_of_copies;
    private Boolean is_print_each_paper;
    private Boolean active;
    private PRINTER_TYPE type;

}
