package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;
//import com.ra.orderapp_java.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

//    @Autowired
//    private AuthService authService;
//
//
//    @PostMapping("/create")
//    public ResponseEntity<UserResponseDTO> createAccount(@RequestBody UserRequestDTO dto){
//        UserResponseDTO responseDTO = authService.createAccount(dto);
//        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
//    }
//    @GetMapping
//    public ResponseEntity<List<UserResponseDTO>> getAllAccount(){
//        return new ResponseEntity<>(authService.findAll(),HttpStatus.OK);
//    }
}
