<h1 align="center">Práctica 2</h1>

## Temas

-   Clases anidadas y clases internas.
-   Clases anónimas.
-   Tipos enumerativos.

## 1. Complete el código de la clase Stack en el paquete practica3, de manera que implemente una pila de String:

```java
public class Stack {
    private java.util.ArrayList items;
    public Stack() {}

    public void push(Object item) {}

    public Object pop() {}

    public boolean isEmpty() {}
}
```

### a) Implemente un método main() para probar la pila. Agregue Strings a la pila y recórrala para imprimir sus valores. ¿Cuántas veces puede recorrerla?

Resuelto en IntelliJ, proyecto "3".

Solo se puede recorrer una vez ya que el pop() no solo devuelve el elemento en el tope de la pila si no que además lo borra.

### b) Agregue una clase anidada llamada StackIterator que provea un objeto de tipo Iterator para recorrer la pila.

??

### c) Agregue en la clase Stack un método para que retorne una instancia de StackIterator. ¿Cuántas veces puede recorrer la pila ahora?

??

### d) ¿Es posible crear objetos StackIterator desde una clase diferente a la clase Stack con el operador new?, ¿cómo lo hace?

??

### e) ¿Cómo haría para evitar crear instancias de una clase anidada desde una clase que no sea la que la definió?

??

## 2. Analice el código que figura debajo:

```java
class InnerStatic {
    static double PI = 3.1416;
    static class Circulo {
        static double radio = 2;
        static double getArea() {
            double a = PI * Math.pow(radio, 2);
            System.out.println("El area es: " + a);
            return a;
        }
        static double getLongitudCircunferencia() {
            double l = 2 * PI * radio;
            System.out.println("La longitud es: " + l);
            return l;
        }
    }
}
```

### a) Modifique el código de la clase interna estática para que el valor inicial del radio sea ingresado por el usuario en el momento de la ejecución.

Resuelto en IntelliJ, proyecto "3".

### b) Defina una clase llamada InnerTest en el paquete practica3 con un método main() que imprime en la pantalla el área y la longitud de la circunferencia. Ejecútela varias veces ingresando distintos radios.

Resuelto en IntelliJ, proyecto "3".

```
3
El area es: 28.2744
La longitud es: 18.8496
```

```
1
El area es: 3.1416
La longitud es: 6.2832
```

```
5
El area es: 78.53999999999999
La longitud es: 31.416
```

### c) Remplazar PI \* Math.pow(radio,2) por PI \* pow(radio,2), siendo pow() el método de la clase java.lang.Math.

Resuelto en IntelliJ, proyecto "3".

Para lograr esto hacemos `import static java.lang.Math.pow;`.

## 3. Implemente una clase llamada StringConverterSet como subclase de AbstractSet, la cual permita realizar todas las operaciones contempladas para los Set, con la salvedad que el método iterator() retorne un Iterator que al recorrerlo devuelva cada uno de los elementos como Strings. Para su solución, defina un Adapter llamado IteratorStringAdapter como una clase anidada de StringConverterSet para cumplir lo solicitado.

Resuelto en IntelliJ, proyecto "3".

Lo resolví haciendo que el método `iterator()` de StringConverterSet (que es el método que se llama en los foreach, por ejemplo) devuelva una instancia de IteratorStringAdapter, que es su clase anidada.

La clase anidada IteratorStringAdapter tiene un `Iterator<String>` y sobreescribe el método `hasNext()` de forma típica, y `next()` de forma que convierta a String el próximo elemento antes de devolverlo.

Output:

```
1 java.lang.String
3 java.lang.String
10 java.lang.String
```

Los enteros 1, 3 y 10 fueron convertidos a String.

## 4. Indicar si son verdaderas o falsas las siguientes afirmaciones sobre las clases anónimas y en cada caso justifique su respuesta:

-   Se pueden instanciar más allá del punto en donde fueron declaradas.

**Falso.** Las clases anónimas solo se pueden instanciar en el mismo lugar donde fueron declaradas. Fuera de ese scope no existen.

-   Unos de los usos más comunes de este tipo de clases es la creación de objetos función y procesos on the fly.

**Verdadero.** Un objeto-función es una instancia de una clase que exporta métodos que realizan operaciones sobre otros objetos que se pasan como parámetros. Las clases anónimas se ajustan muy bien a este propósito ya que Java no soporta la creación de funciones que estén fuera de toda clase.

-   Se puede utilizar el instanceof siempre y cuando la interfaz de la que deriva la clase anónima sea de tipo marker.

**Falso.** El `instanceof` **siempre** se puede usar sobre clases anónimas: 1) si la clase anónima extiende de una clase, su tipo será ese. 2) si implementa una interfaz, su tipo será ese. 3) si no hereda de ninguna clase ni implementa ninguna interfaz, su tipo será Object porque todas las clases, incluídas las anónimas, heredan de Object.

-   No se puede implementar múltiples interfaces o extender clases e implementar interfaces al mismo tiempo.

**Verdadero.** Una clase anónima solo puede implementar **una** única interfaz o extender de **una** única clase. Nunca ambas a la vez.

## 5. Modifique el código de la clase Stack, para que ahora la clase anidada StackIterator, se convierta en una clase anónima.

??

### a) ¿En que situación es conveniente definir a una clase cómo anónima?

??

### b) Si tendría que inicializar valores de la clase anónima (cuando se crea una instancia de la misma), ¿cómo lo haría?

??

## 6. Defina una clase llamada Estudiante:

-   Que contenga las siguientes variables de instancia:

    -   nombre
    -   apellido
    -   edad
    -   legajo
    -   materiasAprobadas

-   Se necesita poder ordenar un arreglo con estos objetos por los siguientes criterios:

    -   Por cantidad de materias aprobadas en forma ascendente.
    -   Por edad en forma descendente.
    -   Por legajo en forma ascendente.
    -   Por nombre y apellido en forma descendente.

-   Implemente un método main() que imprima los resultado de las distintas ordenaciones utilizando clases anónimas y el método Arrays.sort().

Resuelto en IntelliJ, proyecto "3".

## 7. Declaración e implementación de Tipos Enumerativos

### a) Implemente un tipo enumerativo llamado Notas que define los valores de las notas musicales y con su correspondiente cifrado americano (almacenado en un String).

Resuelto en IntelliJ, proyecto "3".

### b) Implemente un tipo enumerativo llamado FrecuenciasDeLA que represente las siguientes frecuencias estándares de afinación:

-   440 Hz: Organización Internacional de Estandarización ISO 16.
-   444 Hz: Afinación de cámara.
-   446 Hz: Renacimiento.
-   480 Hz: Órganos alemanes que tocaba Bach.

Resuelto en IntelliJ, proyecto "3".

### c) Sobrecargue los métodos hacerSonar() y afinar() de la interface InstrumentoMusical del ejercicio 1b) de la práctica 2 de manera que el nuevo hacerSonar(Notas n, int duracion) reciba como parámetro una nota musical y una duración, y el nuevo método afinar(FrecuenciaDeLA f) reciba como parámetro una frecuencia de LA.

Resuelto en IntelliJ, proyecto "3".

### d) Defina una clase llamada Piano que implemente la interface InstrumentoMusical y una clase TestPiano que permita probar los métodos implementados.

Resuelto en IntelliJ, proyecto "3".

### e) Implemente el patrón de diseño Singleton mediante un tipo Enumerativo el cual represente a Fito Páez. Fito cuenta con un instrumento musical (piano) y en algún momento se le puede pedir que toque una canción (especificando un arreglo de notas musicales con sus tiempos).

Resuelto en IntelliJ, proyecto "3".
