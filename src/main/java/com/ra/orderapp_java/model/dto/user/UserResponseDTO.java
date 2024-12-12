package com.ra.orderapp_java.model.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.ra.orderapp_java.model.entity.Role;
import com.ra.orderapp_java.model.entity.User;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private String username;
    private String fullName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    private Set<Role> roles;

    public UserResponseDTO(User user) {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
    }
}
