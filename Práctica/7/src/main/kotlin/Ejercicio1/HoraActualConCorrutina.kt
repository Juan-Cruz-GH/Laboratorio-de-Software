package Ejercicio1

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() = runBlocking {
    val job = launch {
        while (isActive) {
            val fechaHoraActual = LocalDateTime.now()
            val formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
            val horaActual = fechaHoraActual.format(formato)
            print("La hora actual exacta es: $horaActual \n")
            delay(1000)
        }
    }
}