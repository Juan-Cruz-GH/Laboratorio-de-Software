package Ejercicio1

import kotlin.concurrent.fixedRateTimer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val timer = fixedRateTimer("timer", initialDelay = 0, period = 1000) {
        val fechaHoraActual = LocalDateTime.now()
        val formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val horaActual = fechaHoraActual.format(formato)
        print("La hora actual exacta es: $horaActual \n")
    }
}