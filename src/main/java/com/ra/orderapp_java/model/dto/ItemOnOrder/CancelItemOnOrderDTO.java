package com.ra.orderapp_java.model.dto.ItemOnOrder;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelItemOnOrderDTO {
    private Long id;
    private String reason;
}
