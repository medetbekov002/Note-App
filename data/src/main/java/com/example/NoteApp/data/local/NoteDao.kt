package com.example.NoteApp.data.local

import androidx.room.*
import com.example.NoteApp.data.model.NoteEntity

@Dao
interface NoteDao {

    // CRUD
    // C - create
    // R - read
    // U - update
    // D - delete

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}