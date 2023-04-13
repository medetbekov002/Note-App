package com.example.NoteApp.di

import android.content.Context
import androidx.room.Room
import com.example.NoteApp.data.local.NoteDao
import com.example.NoteApp.data.local.NoteDatabase
import com.example.NoteApp.data.repository.NoteRepositoryImpl
import com.example.NoteApp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_db"
    )

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}