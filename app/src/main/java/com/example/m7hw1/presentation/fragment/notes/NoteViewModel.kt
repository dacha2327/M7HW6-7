package com.example.m7hw1.presentation.fragment.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.usecases.DeleteNotesUseCase
import com.example.m7hw1.domain.usecases.GetNotesUseCase
import com.example.m7hw1.domain.utils.Resource
import com.example.m7hw1.presentation.fragment.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNotesUseCase: DeleteNotesUseCase
) : ViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNoteState = _getNotesState.asStateFlow()

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getNotesUseCase.getNotes().collect {
                when(it) {
                    is Resource.Error -> {
                        _getNotesState.value = UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _getNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getNotesState.value = UIState.Success(it.data)
                        }

                    }
                }
            }
        }
    }
}