package com.example.lesson7_1.domain.usecases

import com.example.lesson7_1.domain.model.Note
import com.example.lesson7_1.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) {

    fun createNote(note: Note) = noteRepository.createNote(note)
    
}