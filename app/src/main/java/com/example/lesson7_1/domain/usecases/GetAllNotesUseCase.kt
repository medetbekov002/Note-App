package com.example.lesson7_1.domain.usecases

import com.example.lesson7_1.domain.model.Note
import com.example.lesson7_1.domain.repository.NoteRepository

class GetAllNotesUseCase constructor(private val noteRepository: NoteRepository) {

    fun getAllNotes(note: Note) = noteRepository.getAllNotes()
}