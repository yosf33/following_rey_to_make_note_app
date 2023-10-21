package com.example.reynoteapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserNote(noteEntity: Note)

    @Update
    fun updateNote(noteEntity: Note)

    @Delete
    fun deleteNote(noteEntity: Note)

    @Query("SELECT * FROM note ORDER BY noteId DESC")
    fun getAllNotes() : MutableList<Note>

    @Query("SELECT * FROM note WHERE noteId LIKE :id")
    fun getNote(id : Int) : Note

}
