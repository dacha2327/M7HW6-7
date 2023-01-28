package com.example.m7hw1.domain.repository

import com.example.m7hw1.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun editNote(note: Note)

    fun deleteNote(note: Note)

    fun getNote() : List<Note>
}