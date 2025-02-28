package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.prueba.data.db.DatabaseProvider
import com.example.prueba.data.entities.Author
import com.example.prueba.data.entities.Book
import com.example.prueba.repository.AuthorBookRepository
import com.example.prueba.repository.AuthorRepository
import com.example.prueba.repository.BookRepository
import com.example.prueba.ui.theme.PruebaTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DatabaseProvider.getDatabase(this)
        val repository = AuthorBookRepository(db.authorBookDao())
        val authorRepository = AuthorRepository(db.authorDao())
        val bookRepository = BookRepository(db.bookDao())
        val viewModel = MainActivityViewModel(repository, authorRepository, bookRepository)
        lifecycleScope.launch {
            val authorId: Long = viewModel.insertAuthor(Author(name = "J. R. R. Tolkien"))

            viewModel.insertBook(Book(title = "The Lord of the Rings", genre = "Fantasy", authorId = authorId.toInt()))

//            viewModel.getAllAuthors().collect { authors ->
//                authors.forEach {
//                    println(it)
//                }
//            }

            viewModel.getAuthorWithBooks(authorId.toInt()).collect { authorWithBooks ->
                println(authorWithBooks.author.name)
                authorWithBooks.books.forEach {
                    println("-----------------------------------------------------------------------------------------------------------")
                    println(it.title)
                }
            }
        }




        enableEdgeToEdge()
        setContent {
            PruebaTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaTheme {
        Greeting("Android")
    }
}