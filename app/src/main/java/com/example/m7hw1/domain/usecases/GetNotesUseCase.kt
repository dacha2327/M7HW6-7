package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.repository.NoteRepository

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    fun getNotes() = noteRepository.getNote()
}