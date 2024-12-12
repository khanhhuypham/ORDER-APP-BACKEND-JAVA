package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.auth.login.LoginRequestDTO;
import com.ra.orderapp_java.model.dto.auth.login.LoginResponseDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterRequestDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterResponseDTO;
import com.ra.orderapp_java.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO reqDto){

        LoginResponseDTO resDto = authService.login(reqDto);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO dto){
        System.out.println(dto.getUsername());
        return new ResponseEntity<>(authService.register(dto),HttpStatus.CREATED);
    }

}
