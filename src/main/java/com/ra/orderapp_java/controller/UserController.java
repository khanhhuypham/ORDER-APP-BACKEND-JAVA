package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;
import com.ra.orderapp_java.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> index(){
        List<UserResponseDTO> responseDTOS = userService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO responseDTO = userService.create(dto);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
}