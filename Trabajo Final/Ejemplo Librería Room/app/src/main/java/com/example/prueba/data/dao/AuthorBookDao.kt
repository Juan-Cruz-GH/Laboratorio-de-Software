package com.example.prueba.data.dao

import androidx.room.*
import com.example.prueba.data.relations.AuthorWithBooks
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorBookDao {

    @Transaction
    @Query("SELECT * FROM authors WHERE authorId = :authorId")
    fun getAuthorWithBooks(authorId: Int): Flow<AuthorWithBooks>

}
