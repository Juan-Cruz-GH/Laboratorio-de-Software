package com.example.prueba.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prueba.data.dao.AuthorBookDao
import com.example.prueba.data.dao.AuthorDao
import com.example.prueba.data.dao.BookDao
import com.example.prueba.data.entities.Author
import com.example.prueba.data.entities.Book

@Database(entities = [Author::class, Book::class], version = 1, exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun authorDao(): AuthorDao
    abstract fun bookDao(): BookDao
    abstract fun authorBookDao(): AuthorBookDao
}


