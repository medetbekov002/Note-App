package com.example.NoteApp.domain.repository

import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>
}