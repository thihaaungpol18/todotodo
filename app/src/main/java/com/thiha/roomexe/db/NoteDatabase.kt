package com.thiha.roomexe.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
project: RoomExe
Created by : Thiha
date : 6/25/2020
 */
@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}