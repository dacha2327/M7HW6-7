package com.example.m7hw1.domain.usecases

import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    
    fun deleteNotes(note: Note) = noteRepository.deleteNote(note)
}