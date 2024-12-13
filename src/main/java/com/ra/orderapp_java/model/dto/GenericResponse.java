package com.ra.orderapp_java.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T> GenericResponse<T> empty() {
        return success(null);
    }

    public static <T> GenericResponse<T> success(T data) {
        if (data != null){
            return GenericResponse.<T>builder()
                    .message("SUCCESS!")
                    .data(data)
                    .status(HttpStatus.OK.value())
                    .build();
        }else{
            return GenericResponse.<T>builder()
                    .message("NO CONTENT!")
                    .data(data)
                    .status(HttpStatus.NO_CONTENT.value())
                    .build();
        }


    }

    public static <T> GenericResponse<T> error() {
        return GenericResponse.<T>builder()
                .message("ERROR!")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}