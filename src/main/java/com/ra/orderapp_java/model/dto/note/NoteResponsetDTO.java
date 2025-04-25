package com.ra.orderapp_java.model.dto.note;

import com.ra.orderapp_java.model.entity.Note;
import com.ra.orderapp_java.model.entity.Printer;
import lombok.*;


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
public class NoteResponsetDTO {
    private Long id;
    private String content;

    public NoteResponsetDTO(Note note) {
        this.id = note.getId();
        this.content = note.getContent();

    }
}
