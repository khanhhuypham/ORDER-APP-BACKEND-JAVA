package com.ra.orderapp_java.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ResponseWrapper<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T> ResponseWrapper<T> empty() {
        return success(null);
    }

    public static <T> ResponseWrapper<T> success(T data) {
        if (data != null){
            return ResponseWrapper.<T>builder()
                    .message("SUCCESS!")
                    .data(data)
                    .status(HttpStatus.OK.value())
                    .build();
        }else{
            return ResponseWrapper.<T>builder()
                    .message("NO CONTENT!")
                    .data(data)
                    .status(HttpStatus.NO_CONTENT.value())
                    .build();
        }
    }

//    public static <T> GenericResponse<T> error() {
//        return GenericResponse.<T>builder()
//                .message("ERROR!")
//                .status(HttpStatus.BAD_REQUEST.value())
//                .build();
//    }

    public static <T> ResponseWrapper<T> unKnownError(String message) {
        return ResponseWrapper.<T>builder()
                .message(message == null ? "ERROR!" : message)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}