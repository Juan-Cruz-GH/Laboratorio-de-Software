package com.example.prueba.repository

import com.example.prueba.data.dao.AuthorDao
import com.example.prueba.data.entities.Author
import kotlinx.coroutines.flow.Flow

class AuthorRepository(private val dao: AuthorDao) {
    fun getAll(): Flow<List<Author>> = dao.getAllAuthors();

    suspend fun insert(author: Author): Long = dao.insert(author);
}