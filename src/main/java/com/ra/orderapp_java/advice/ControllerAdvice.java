package com.ra.orderapp_java.advice;

import com.ra.orderapp_java.model.dto.response.CommonError;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonError<Map<String,String>> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new CommonError<>(map,400);
    }


    /**
     * @apiNote handle exception max upload file
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> handleMaxUploadFile()
    {
        return ResponseEntity.badRequest().body(
                ResponseWrapper.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .code(400)
                        .data("File so big")
                        .build()
        );
    }

    /**
     * @param ex UsernameNotFoundException
     * @apiNote handle exception username not found in user detail service
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex)
    {
        return new ResponseEntity<>(
                ResponseWrapper.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .code(404)
                        .data(ex.getMessage())
                        .build()
                , HttpStatus.NOT_FOUND
        );
    }


    /**
     * @param e StripeException
     * @apiNote handle exception when calling Stripe's api fail
     */
    @ExceptionHandler(StripeException.class)
    public ResponseEntity<?> handleStripeException(StripeException e) {
        return new ResponseEntity<>(
                ResponseWrapper.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .code(404)
                        .data(e.getMessage())
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    /**
     * @param ex CustomException
     * @apiNote handle custom exception
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(
                ResponseWrapper.builder()
                        .status(ex.getStatus())
                        .code(ex.getStatus().value())
                        .data(ex.getMessage())
                        .build(),
                ex.getStatus()
        );
    }







}
