package com.example.prueba.repository

import com.example.prueba.data.dao.AuthorBookDao
import com.example.prueba.data.relations.AuthorWithBooks
import kotlinx.coroutines.flow.Flow

class AuthorBookRepository(private val dao: AuthorBookDao) {
    fun getAuthorWithBooks(authorId: Int): Flow<AuthorWithBooks> = dao.getAuthorWithBooks(authorId)
}
