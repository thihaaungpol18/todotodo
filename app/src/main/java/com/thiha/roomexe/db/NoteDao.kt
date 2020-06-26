package com.thiha.roomexe.db

import androidx.room.*

/**
project: RoomExe
Created by : Thiha
date : 6/25/2020
 */
@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY id")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM Note WHERE id = :noteID")
    fun getNote(noteID: Int): Note

}