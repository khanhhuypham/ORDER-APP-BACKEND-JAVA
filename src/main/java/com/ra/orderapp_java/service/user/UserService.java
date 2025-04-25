package com.ra.orderapp_java.service.user;



import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;
import com.ra.orderapp_java.model.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
    User findById(Long id)  throws CustomException;
    UserResponseDTO create(UserRequestDTO dto);
}
