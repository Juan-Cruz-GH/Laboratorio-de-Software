<h1 align="center">Práctica 7</h1>

## Temas

-   Threads. Ciclo de vida.
-   Sincronización de threads.
-   Ejecutores.

## 1. Implemente en Kotlin una aplicación que muestre la hora actual en consola y la actualice cada 1 segundo. Evalúe distintos mecanismos para hacerlo.

Resuelto en IntelliJ, proyecto "7".

## 2. Analice el siguiente código Kotlin y responda:

```kt
class TestSynchronized(id: String) : Thread(id) {
    var frase: Array<String> = arrayOf("UNLP", "PÚBLICA", "AHORA", "Y", "SIEMPRE")
    override fun run() {
        synchronized(System.out) {
            for (palabra in frase)
                println("${this.name} : ${palabra} ")
        }
    }
}

fun main(args: Array<String>) {
    val t1 = TestSynchronized("Thread 1")
    val t2 = TestSynchronized("Thread 2")
    val t3 = TestSynchronized("Thread 3")
    t1.start()
    t2.start()
    t3.start()
}
```

### a) ¿Cuál es el efecto del synchronized(System.out)?

La sincronización en System.out significa que si un hilo está imprimiendo, otro hilo debe **esperar a que el primero termine antes de poder imprimir su contenido**. Esto permite que el código se ejecute de manera ordenada y sin interferencias, asegurando que cada hilo imprima **todas** sus palabras en orden antes de que otro hilo gane acceso a la consola.

### b) ¿Qué tipo de lock hace el código dado?

El código dado hace un lock de tipo **monitor lock**, que es el mecanismo de sincronización básico en Kotlin y en Java. Lo que bloquea este lock es `System.out`, de modo que cada hilo debe adquirir el bloqueo en ese objeto para ejecutar la sección de código dentro de **synchronized**.

Dado que cada hilo debe adquirir el bloqueo en `System.out` para imprimir, el uso de **synchronized** evita que las salidas de los hilos se mezclen en la consola. Sin embargo, el orden de ejecución entre los hilos no está definido, ya que depende de la planificación del sistema operativo.

## 3. Implemente una aplicación que simule una carrera de 100 metros, donde cada participante está representado por un objeto thread. Para ello, cree un programa que muestre por consola la cantidad de metros recorrida por cada corredor.

### a) Use un ejecutor con un pool de tamaño 5 para ejecutar. Luego cambie el tamaño del pool a 3 y observe la ejecución de los threads.

Cuando tenemos 5 corredores pero un tamaño de pool menor a 5, como por ejemplo 3, lo que ocurre es que solo 3 corredores podrán ejecutarse en simultáneo, mientras que los otros 2 tendrán que esperar a que alguno de los 3 corredores termine para poder empezar a ejecutarse.

### b) Supongamos que se quiere saber si un corredor abandona la carrera, retornando algún valor predefinido o en el peor de los casos, disparando una excepción. Analice la interface Callable, usando la documentación de la API y observe sus ventajas.

Diferencias entre Runnable y Callable:

| Runnable                                                                   | Callable                                                                 |
| -------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| Representa un comando que puede ser ejecutado por un thread.               | Representa una tarea que retorna un valor y puede lanzar una excepción.  |
| El método run() no devuelve nada.                                          | El método call() siempre retorna un valor y puede lanzar una excepción.  |
| El método run() no puede lanzar excepciones chequeadas, solo inchequeadas. | El método call() puede lanzar excepciones chequeadas.                    |
| Se usa con classes como Thread e interfaces como Executor.                 | Se usa con utilidades de concurrencia como FutureTask y ExecutorService. |
