package com.ra.orderapp_java.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.awt.print.Pageable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PaginationDTO<T> {
    private Long total_record;
    private Integer page;
    private Integer limit;
    private List<T> list;


    public static <T, G> PaginationDTO<T> input(List<T> data, Page<G> page) {
        return PaginationDTO.<T>builder()
                .total_record(page.getTotalElements()) // Use getTotalElements()
                .page(page.getNumber() + 1) // Page numbers usually start from 1 in APIs, adjust if necessary
                .limit(page.getSize())
                .list(data)
                .build();
    }
}
