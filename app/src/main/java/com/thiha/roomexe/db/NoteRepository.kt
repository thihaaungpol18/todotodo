package com.thiha.roomexe.db

import androidx.lifecycle.LiveData

/**
project: RoomExe
Created by : Thiha
date : 6/26/2020
 */
class NoteRepository(private val noteDAO: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDAO.getAllNotes()

    suspend fun insert(note: Note) {
        noteDAO.insertNote(note)
    }

}