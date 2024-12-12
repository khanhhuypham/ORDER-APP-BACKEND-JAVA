package com.ra.orderapp_java.model.dto.auth.login;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequestDTO {
    private String username;
    private String password;
}
