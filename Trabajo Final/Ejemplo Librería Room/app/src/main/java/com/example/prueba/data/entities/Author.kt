package com.example.prueba.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(
    @PrimaryKey(autoGenerate = true) val authorId: Int = 0,
    val name: String,
    val bio: String? = null
)