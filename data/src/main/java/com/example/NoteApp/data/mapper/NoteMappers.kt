package com.example.NoteApp.data.mapper

import com.example.NoteApp.data.model.NoteEntity
import com.example.NoteApp.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, tittle, description
)

fun NoteEntity.toNote() = Note(
    id, tittle, description
)