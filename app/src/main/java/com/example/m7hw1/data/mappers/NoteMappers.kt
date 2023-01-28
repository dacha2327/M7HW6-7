package com.example.m7hw1.data.mappers

import com.example.m7hw1.data.model.NoteEntity
import com.example.m7hw1.domain.model.Note

fun NoteEntity.toNote() = Note(
    id, title, desc, createdAd
)

fun Note.toNoteEntity() = NoteEntity(
    id, title, desc, createdAd
)