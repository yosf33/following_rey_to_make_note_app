package com.example.reynoteapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val noteId :Int,
    @ColumnInfo(name = "note_title")
    val noteTitle:String,
    @ColumnInfo(name = "note_desc")
    val noteDesc : String
)

