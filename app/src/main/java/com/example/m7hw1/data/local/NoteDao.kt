package com.example.m7hw1.data.local

import androidx.room.*
import com.example.m7hw1.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getNote() : List<NoteEntity>
}