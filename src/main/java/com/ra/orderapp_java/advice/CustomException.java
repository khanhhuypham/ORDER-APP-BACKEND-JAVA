package com.ra.orderapp_java.advice;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception {
    private final HttpStatus status;

    public CustomException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }


}