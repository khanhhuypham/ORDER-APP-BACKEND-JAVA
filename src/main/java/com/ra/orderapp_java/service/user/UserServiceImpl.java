package com.ra.orderapp_java.service.user;

import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;
import com.ra.orderapp_java.model.entity.User;
import com.ra.orderapp_java.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<UserResponseDTO> list = new ArrayList<>();

        for (User user: userRepo.findAll()) {
            list.add(new UserResponseDTO(user));
        }

        return list;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = new User(dto);
        return new UserResponseDTO(userRepo.save(user));
    }
}
