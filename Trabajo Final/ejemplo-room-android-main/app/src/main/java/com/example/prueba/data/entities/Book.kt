package com.example.prueba.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) val bookId: Int = 0,
    val title: String,
    val genre: String,
    val authorId: Int
)