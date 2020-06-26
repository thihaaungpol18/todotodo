package com.thiha.roomexe.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
project: RoomExe
Created by : Thiha
date : 6/23/2020
 */
@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "column_title") val title: String,
    @ColumnInfo(name = "column_description") val description: String,
    @ColumnInfo(name = "column_date") val date: String
)