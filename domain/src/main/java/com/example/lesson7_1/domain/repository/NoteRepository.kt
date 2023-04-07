package com.example.lesson7_1.domain.repository

import com.example.lesson7_1.domain.model.Note
import com.example.lesson7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>
}