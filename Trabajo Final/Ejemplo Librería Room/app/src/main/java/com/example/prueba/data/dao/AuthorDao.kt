package com.example.prueba.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba.data.entities.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(author: Author): Long

    @Query("SELECT * FROM authors")
    fun getAllAuthors(): Flow<List<Author>>

    @Delete
    suspend fun deleteAuthor(author: Author)

}
