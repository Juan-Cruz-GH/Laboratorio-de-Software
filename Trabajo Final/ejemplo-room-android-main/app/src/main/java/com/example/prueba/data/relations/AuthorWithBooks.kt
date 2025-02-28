package com.example.prueba.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.prueba.data.entities.Author
import com.example.prueba.data.entities.Book

data class AuthorWithBooks(
    @Embedded val author: Author,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "authorId"
    )
    val books: List<Book>
)
