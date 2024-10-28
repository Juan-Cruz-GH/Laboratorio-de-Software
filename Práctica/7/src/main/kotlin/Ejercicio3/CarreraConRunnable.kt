package Ejercicio3

import kotlin.random.Random
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Corredor1(private val nombre: String) : Runnable {
    override fun run() {
        var metrosRecorridos = 0
        while (metrosRecorridos < 20) {
            // Simula el tiempo que tarda en correr un metro (entre 100 y 300 ms)
            Thread.sleep(Random.nextLong(100, 300))

            metrosRecorridos++
            println("$nombre ha recorrido $metrosRecorridos metros.")
        }
        println("$nombre ha terminado la carrera!")
    }
}
fun main(args: Array<String>) {
    val tamañoPool = 3
    val executor: ExecutorService = Executors.newFixedThreadPool(tamañoPool)

    val corredores = listOf("Corredor 1", "Corredor 2", "Corredor 3", "Corredor 4", "Corredor 5")

    corredores.forEach { nombre ->
        executor.submit(Corredor1(nombre))
    }

    executor.shutdown()
}