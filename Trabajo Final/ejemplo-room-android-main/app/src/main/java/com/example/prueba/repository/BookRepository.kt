package com.example.prueba.repository

import com.example.prueba.data.dao.BookDao
import com.example.prueba.data.entities.Book
import kotlinx.coroutines.flow.Flow


class BookRepository(private val dao: BookDao) {
    fun getAll(authorId: Long): Flow<List<Book>> = dao.getBooksByAuthorId(authorId);

    suspend fun insert(book: Book): Long = dao.insert(book);
}