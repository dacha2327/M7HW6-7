package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun getNotes() = noteRepository.getNote()
}