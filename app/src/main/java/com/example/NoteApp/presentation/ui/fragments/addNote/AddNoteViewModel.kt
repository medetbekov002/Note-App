package com.example.NoteApp.presentation.ui.fragments.addNote

import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.domain.usecase.CreateNoteUseCase
import com.example.NoteApp.domain.usecase.EditNoteUseCase
import com.example.NoteApp.presentation.base.BaseViewModel
import com.example.NoteApp.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
): BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun addNote(note: Note) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }

    fun editNote(note: Note){
        editNoteUseCase.editNote(note).collectFlow(_editNoteState)
    }
}