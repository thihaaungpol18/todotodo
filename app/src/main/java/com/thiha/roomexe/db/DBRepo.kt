package com.thiha.roomexe.db

import android.content.Context
import androidx.room.Room

/**
project: RoomExe
Created by : Thiha
date : 6/26/2020
 */
object DBRepo {
    private var database: NoteDatabase? = null
    fun getInstance(context: Context): NoteDatabase {
        if (database == null) {
            database = Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                "notes.db"
            ).build()
        }
        return database!!
    }
}