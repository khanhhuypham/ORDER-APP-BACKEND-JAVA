package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
