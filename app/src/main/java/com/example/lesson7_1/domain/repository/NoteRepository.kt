package com.example.lesson7_1.domain.repository

import android.provider.ContactsContract
import com.example.lesson7_1.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun editNote(note: Note)

    fun getAllNotes(): List<Note>

    fun deleteNote(note: Note)
}