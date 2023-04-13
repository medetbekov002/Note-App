package com.example.NoteApp.domain.usecase

import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)
}