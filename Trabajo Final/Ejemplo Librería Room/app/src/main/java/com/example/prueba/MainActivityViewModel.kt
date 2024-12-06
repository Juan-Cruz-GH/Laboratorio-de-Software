package com.example.prueba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.data.entities.Author
import com.example.prueba.data.entities.Book
import com.example.prueba.data.relations.AuthorWithBooks
import com.example.prueba.repository.AuthorBookRepository
import com.example.prueba.repository.AuthorRepository
import com.example.prueba.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivityViewModel (
    private val repository: AuthorBookRepository,
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
) : ViewModel() {

    fun getAllAuthors(): Flow<List<Author>> = authorRepository.getAll()

    fun getAuthorWithBooks(authorId: Int): Flow<AuthorWithBooks> = repository.getAuthorWithBooks(authorId)

    suspend fun insertAuthor(author: Author): Long {
        return authorRepository.insert(author)
    }

    fun insertBook(book: Book) {
        viewModelScope.launch {
            bookRepository.insert(book)
        }
    }

}
