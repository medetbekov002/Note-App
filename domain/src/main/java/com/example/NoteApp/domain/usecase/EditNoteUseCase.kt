package com.example.NoteApp.domain.usecase

import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
    private val a: String,
) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}
