package com.example.NoteApp.data.repository

import com.example.NoteApp.data.base.BaseRepository
import com.example.NoteApp.data.local.NoteDao
import com.example.NoteApp.data.mapper.toEntity
import com.example.NoteApp.data.mapper.toNote
import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAo: NoteDao
) : NoteRepository,
    BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDAo.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDAo.getAllNotes().map {
            it.toNote()
        }
    }


    override fun editNote(note: Note) = doRequest {
        noteDAo.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDAo.deleteNote(note.toEntity())
    }
}