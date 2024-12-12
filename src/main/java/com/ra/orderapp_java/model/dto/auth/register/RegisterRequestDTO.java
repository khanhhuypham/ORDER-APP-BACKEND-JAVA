package com.ra.orderapp_java.model.dto.auth.register;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequestDTO {
    private String fullName;
    private String username;
    private String password;
}
