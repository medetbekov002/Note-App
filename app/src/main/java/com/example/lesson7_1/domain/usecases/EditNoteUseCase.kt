package com.example.lesson7_1.domain.usecases

import com.example.lesson7_1.domain.model.Note
import com.example.lesson7_1.domain.repository.NoteRepository

class EditNoteUseCase (private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}
