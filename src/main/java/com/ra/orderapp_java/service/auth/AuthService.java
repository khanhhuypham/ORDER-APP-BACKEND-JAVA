package com.ra.orderapp_java.service.auth;

import com.ra.orderapp_java.model.dto.auth.login.LoginRequestDTO;
import com.ra.orderapp_java.model.dto.auth.login.LoginResponseDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterRequestDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterResponseDTO;
import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;

import java.util.List;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO dto);
    RegisterResponseDTO register(RegisterRequestDTO dto);

    UserResponseDTO createAccount(UserRequestDTO dto);
    List<UserResponseDTO> findAll();
}
