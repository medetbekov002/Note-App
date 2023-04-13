package com.example.NoteApp.domain.usecase

import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}