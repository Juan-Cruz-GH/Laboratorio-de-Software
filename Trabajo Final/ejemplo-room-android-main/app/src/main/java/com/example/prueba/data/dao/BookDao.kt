package com.example.prueba.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba.data.entities.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book): Long

    @Query("SELECT * FROM books WHERE authorId = :authorId")
    fun getBooksByAuthorId(authorId: Long): Flow<List<Book>>

    @Delete
    suspend fun deleteBook(book: Book)

}