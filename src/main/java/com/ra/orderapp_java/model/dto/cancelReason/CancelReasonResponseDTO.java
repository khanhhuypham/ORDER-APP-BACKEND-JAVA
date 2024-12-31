package com.ra.orderapp_java.model.dto.cancelReason;

import com.ra.orderapp_java.model.entity.CancelReason;
import com.ra.orderapp_java.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelReasonResponseDTO {

    private Long id;
    private String content;
    public CancelReasonResponseDTO(CancelReason cancelReason) {
        this.id = cancelReason.getId();
        this.content = cancelReason.getContent();
    }
}


