package com.ra.orderapp_java.service.note;

import com.ra.orderapp_java.model.dto.note.NoteRequestDTO;
import com.ra.orderapp_java.model.dto.note.NoteResponsetDTO;
import com.ra.orderapp_java.model.dto.printer.PrinterResponseDTO;
import com.ra.orderapp_java.model.entity.Note;
import com.ra.orderapp_java.model.entity.Printer;
import com.ra.orderapp_java.repository.NoteRepository;
import com.ra.orderapp_java.repository.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepo;

    @Override
    public List<NoteResponsetDTO> findAll() {

        List<NoteResponsetDTO> list = new ArrayList();
        for(Note note : noteRepo.findAll()) {
            list.add(new NoteResponsetDTO(note));
        }
        return list;
    }

    @Override
    public NoteResponsetDTO create(Long id, NoteRequestDTO dto) {
        Note note = noteRepo.save(Note.builder()
            .id(id)
            .content(dto.getContent())
            .build());
        return new NoteResponsetDTO(note);
    }

    @Override
    public NoteResponsetDTO findById(Long id) {
        Note note = noteRepo.findById(id).orElse(null);
        return note == null ? null : new NoteResponsetDTO(note);

    }

    @Override
    public void delete(long id) {
        noteRepo.deleteById(id);
    }
}
