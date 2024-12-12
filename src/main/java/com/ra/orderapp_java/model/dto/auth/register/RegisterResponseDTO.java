package com.ra.orderapp_java.model.dto.auth.register;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterResponseDTO {
    private String fullName;
    private String userName;
}