import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking
import java.util.concurrent.*

class Cliente(private val nombre: String) : Callable<String> {
    override fun call(): String {
        var cliente = HttpClient(CIO)
        try {
            // Se hace la solicitud GET
            val response = cliente.get("http://127.0.0.1:8000/parcial/")
            return response.toString()
        } catch (e: Exception) {
            println("Error realizando la solicitud: ${e.message}")
        } finally {
            // Se cierra el cliente al terminar
            cliente.close()
        }
    }
}

fun main() {
    val executor: ExecutorService  = Executors.newFixedThreadPool(3)

    val clientes = listOf("1", "2", "3")

    val resultados: List<Future<String>> = clientes.map {
        id -> executor.submit(Cliente(id))
    }

    var listaEnteros: List<String> = listOf()
    resultados.forEach { future ->
        try {
            listaEnteros.add(future.get())
        } catch (e: ExecutionException) {
            println("Error: ${e.cause?.message}")
        } catch (e: InterruptedException) {
            println("La ejecución fue interrumpida")
        }
    }

    println(listaEnteros)

    executor.shutdown()
}

