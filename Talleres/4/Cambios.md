# Lista de cosas que se cambiaron y por qué:

1. Todos los cambios en los archivos LaboRobot, Estratega y Estrategia fueron únicamente de sintaxis, la lógica es la misma.
2. En la clase EstrategiaImplementacion se tuvieron que hacer varios cambios:
    1. Se le define un **private constructor()** para evitar que otras clases instancien esta clase por fuera (ayuda para el Singleton).
    2. Se usa un "companion object" para crear la variable estática **instance** que se usa para implementar el patrón Singleton.
    3. Se usa "?" adelante de la declaración de **instance** para permitir que se lo defina como null en un principio.
    4. Se usa "!!" adelante de **return instance** para castear la variable a un tipo no nulleable.
    5. Se usa **inner** para definir clases internas, a diferencia de Java, donde se usa **static**.
    6. Cuando se llama a robot.fire(), se pasan números **double** en vez de **int**. En Java se casteaba a double automáticamente, pero en Kotlin no.
