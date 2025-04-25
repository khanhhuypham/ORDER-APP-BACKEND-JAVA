package com.ra.orderapp_java.controller;

import com.ra.orderapp_java.model.dto.ResponseWrapper;
import com.ra.orderapp_java.model.dto.note.NoteRequestDTO;
import com.ra.orderapp_java.model.dto.note.NoteResponsetDTO;
import com.ra.orderapp_java.service.note.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper<List<NoteResponsetDTO>>> index(){
        return new ResponseEntity<>(ResponseWrapper.success(noteService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<NoteResponsetDTO>> create(@RequestBody NoteRequestDTO dto){
        return new ResponseEntity<>(ResponseWrapper.success(noteService.create(null,dto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<NoteResponsetDTO>> findById(@PathVariable long id){
        NoteResponsetDTO dto = noteService.findById(id);
        return new ResponseEntity<>(
                ResponseWrapper.success(dto),
                dto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<NoteResponsetDTO>> update(@PathVariable Long id, @RequestBody NoteRequestDTO dto){
        return new ResponseEntity<>(
                ResponseWrapper.success(noteService.create(id,dto)),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
