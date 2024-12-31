package com.ra.orderapp_java.model.dto.cancelReason;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelReasonRequestDTO {
    @NotBlank(message = "content is not empty")
    private String content;
}
