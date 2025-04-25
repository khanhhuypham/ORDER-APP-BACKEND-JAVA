package com.ra.orderapp_java.service.note;

import com.ra.orderapp_java.model.dto.note.NoteRequestDTO;
import com.ra.orderapp_java.model.dto.note.NoteResponsetDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterRequestDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;

import java.util.List;

public interface NoteService {
    List<NoteResponsetDTO> findAll();
    NoteResponsetDTO create(Long id, NoteRequestDTO dto);
    NoteResponsetDTO findById(Long id);
    void delete(long id);
}
