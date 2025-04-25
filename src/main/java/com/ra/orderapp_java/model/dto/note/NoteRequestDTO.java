package com.ra.orderapp_java.model.dto.note;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NoteRequestDTO {
    private String content;
}
