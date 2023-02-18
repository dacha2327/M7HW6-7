package com.example.m7hw1.presentation.fragment.edit_note

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.usecases.CreateNotesUseCase
import com.example.m7hw1.domain.usecases.EditNotesUseCase
import com.example.m7hw1.presentation.base.BaseViewModel
import com.example.m7hw1.presentation.fragment.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val createNotesUseCase: CreateNotesUseCase,
    private val editNotesUseCase: EditNotesUseCase
) : BaseViewModel() {

    private val _editNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNotesState.asStateFlow()

    private val _createNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNotesState.asStateFlow()

    fun editNotes(note: Note) {
        editNotesUseCase.editNotes(note).collectFlow(_editNotesState)
    }

    fun createNotes(note: Note) {
        createNotesUseCase.createNotes(note).collectFlow(_createNotesState)
    }
}