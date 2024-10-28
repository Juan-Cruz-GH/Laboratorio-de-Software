package Ejercicio3

import java.util.concurrent.*
import kotlin.random.Random

class Corredor2(private val nombre: String) : Callable<String> {
    override fun call(): String {
        var metrosRecorridos = 0
        while (metrosRecorridos < 20) {
            // Simula el tiempo que tarda en correr un metro (entre 100 y 300 ms)
            if (Random.nextInt(1, 10) == 2) {
                throw Exception("$nombre ha abandonado la carrera!")
            }

            Thread.sleep(Random.nextLong(100, 300))
            metrosRecorridos++
            println("$nombre ha recorrido $metrosRecorridos metros.")
        }
        return "$nombre ha terminado la carrera!"
    }
}
fun main(args: Array<String>) {
    val tamañoPool = 5
    val executor: ExecutorService = Executors.newFixedThreadPool(tamañoPool)

    val corredores = listOf("Corredor 1", "Corredor 2", "Corredor 3", "Corredor 4", "Corredor 5")

    val resultados: List<Future<String>> = corredores.map { nombre ->
        executor.submit(Corredor2(nombre))
    }

    resultados.forEach { future ->
        try {
            println(future.get())
        } catch (e: ExecutionException) {
            println("Error: ${e.cause?.message}")
        } catch (e: InterruptedException) {
            println("La ejecución fue interrumpida.")
        }
    }

    executor.shutdown()
}