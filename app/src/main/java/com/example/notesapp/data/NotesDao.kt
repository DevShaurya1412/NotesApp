package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import java.util.concurrent.Flow

@Dao
interface NotesDao {

    @Upsert
    suspend fun upsurtNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getOrderedByTitle(): kotlinx.coroutines.flow.Flow<List<Note>>

    @Query("SELECT * FROM note ORDER BY dateAdded ASC")
    fun getOrderedByDateAdded(): kotlinx.coroutines.flow.Flow<List<Note>>



}