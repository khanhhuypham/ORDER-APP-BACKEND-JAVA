package com.ra.orderapp_java.model.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDTO<T> {
    private int httpStatus;
    private  String message;
    private T data;
}
