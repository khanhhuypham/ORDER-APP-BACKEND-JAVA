package com.ra.orderapp_java.model.dto.auth.login;

import com.ra.orderapp_java.model.entity.Role;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseDTO {
    private String fullName;
    private String username;
    private String accessToken;
    private String typeToken;
    private Set<Role> roles;
}
