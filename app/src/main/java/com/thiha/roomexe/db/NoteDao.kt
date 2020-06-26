package com.thiha.roomexe.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
project: RoomExe
Created by : Thiha
date : 6/25/2020
 */
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNotes()

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note_table WHERE id = :noteID")
    suspend fun getNote(noteID: Int): Note

}