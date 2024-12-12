package com.ra.orderapp_java.service.auth;

import com.ra.orderapp_java.model.dto.auth.login.LoginRequestDTO;
import com.ra.orderapp_java.model.dto.auth.login.LoginResponseDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterRequestDTO;
import com.ra.orderapp_java.model.dto.auth.register.RegisterResponseDTO;
import com.ra.orderapp_java.model.dto.user.UserRequestDTO;
import com.ra.orderapp_java.model.dto.user.UserResponseDTO;
import com.ra.orderapp_java.model.entity.Role;
import com.ra.orderapp_java.model.entity.User;
import com.ra.orderapp_java.repository.RoleRepository;
import com.ra.orderapp_java.repository.UserRepository;
import com.ra.orderapp_java.security.UserPrinciple;
import com.ra.orderapp_java.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    public LoginResponseDTO login(LoginRequestDTO dto){
        Authentication authentication;
        authentication = authenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        return LoginResponseDTO.builder()
                .username(userPrinciple.getUsername())
                .fullName(userPrinciple.getUser().getFullName())
                .accessToken(jwtProvider.generateToken(userPrinciple))
                .typeToken("Bearer")
                .roles(userPrinciple.getUser().getRoles())
                .build();
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepo.findRoleByName("USER");
        roles.add(role);
        User userEntity = User.builder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .password(new BCryptPasswordEncoder().encode(dto.getPassword()))
                .status(true)
                .roles(roles)
                .build();
        User user = userRepo.save(userEntity);
        return RegisterResponseDTO.builder()
                .fullName(user.getFullName())
                .userName(user.getUsername())
                .build();
    }



    @Override
    public UserResponseDTO createAccount(UserRequestDTO dto) {
        Set<Role> roles = new HashSet<>();
        // lấy về danh sách các quyền dựa vào mảng quyền bắt lên từ client
        dto.getRoles().forEach(roleName->{
            Role role = roleRepo.findRoleByName(roleName);
            roles.add(role);
        });
        User userEntity = User.builder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .password(new BCryptPasswordEncoder().encode(dto.getPassword()))
                .roles(roles)
                .status(true)
                .build();
        User user = userRepo.save(userEntity);
        return UserResponseDTO.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(user ->
                UserResponseDTO.builder()
                        .fullName(user.getFullName())
                        .username(user.getUsername())
                        .roles(user.getRoles())
                        .build()).toList();
    }

}
