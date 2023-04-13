package com.example.NoteApp.domain.usecase

import com.example.NoteApp.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun getAllNotes() = noteRepository.getAllNotes()
}