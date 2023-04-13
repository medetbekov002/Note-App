package com.example.NoteApp.presentation.ui.fragments.addNote

import android.annotation.SuppressLint
import android.os.Build
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.NoteApp.R
import com.example.NoteApp.databinding.FragmentAddNoteBinding
import com.example.NoteApp.domain.model.Note
import com.example.NoteApp.presentation.base.BaseFragment
import com.example.NoteApp.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(R.layout.fragment_add_note) {

    override val viewModel: AddNoteViewModel by viewModels()
    override val binding by viewBinding(FragmentAddNoteBinding::bind)
    private var note: Note? = null
    private var noteIsNull = true

    override fun initialize() {
        super.initialize()
        getNote()
    }

    override fun initRequests() {
        super.initRequests()
        addOrEdit()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        collectAddNote()
        collectEditNote()
    }

    @SuppressLint("SetTextI18n")
    private fun getNote() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (arguments?.getSerializable("KEY_UPDATE_NOTE") == null) {
                note = Note()
            } else {
                note = arguments?.getSerializable("KEY_UPDATE_NOTE", Note::class.java)
                binding.etTitle.setText(note!!.tittle)
                binding.etDesc.setText(note!!.description)
                binding.btnAdd.text = "Edit"
                noteIsNull = false
            }
        }
    }

    private fun addOrEdit() {
        with(binding) {
            btnAdd.setOnClickListener {
                if (binding.etTitle.text.isNotEmpty() && binding.etDesc.text.isNotEmpty()) {
                    note?.tittle = etTitle.text.toString()
                    note?.description = etDesc.text.toString()
                    if (noteIsNull) {
                        viewModel.addNote(note!!)
                    } else {
                        viewModel.editNote(note!!)
                    }
                } else {
                    requireActivity().showToast("Заполните поля")
                }
            }
        }
    }

    private fun collectAddNote() {
        viewModel.createNoteState.collectUIState(
            onLoading = {},
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

    private fun collectEditNote() {
        viewModel.editNoteState.collectUIState(
            onLoading = {},
            onSuccess = { findNavController().navigateUp() }
        )
    }
}