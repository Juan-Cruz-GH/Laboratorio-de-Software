<h1 align="center">Práctica 1</h1>

## Temas

-   Especificadores de acceso: private, public, protected, default.
-   Constructores de Clases.
-   Clases abstractas.

## 1. Escriba una clase llamada Vacuna con 4 variables de instancia: marca, país de origen, enfermedad que previene y cantidad de dosis. Implemente los getters y setters para cada una de las variables de instancias anteriores.

### a) Sobre-escriba el método toString() de Object, para ello declare una variable local de tipo StringBuffer y utilícela para concatenar cada uno de los datos de la vacuna y retorne un objeto String con los datos del mismo.

Resuelto en Eclipse (proyecto Java "Práctica_1").

### b) Escriba el método main() en la clase TestVacuna, donde se debe crear un arreglo con 5 objetos Vacuna inicializados, para luego recorrer el arreglo e imprimir en pantalla los objetos guardados en él.

Resuelto en Eclipse (proyecto Java "Práctica_1").

### c) Comente el método toString() escrito en la clase Vacuna y vuelva a ejecutar el programa. ¿Cuál es la diferencia entre b) y c)?

Al comentar el método toString que sobreescribimos en el inciso b), cuando hacemos `System.out.println(vacuna)`, se ejecutará el método toString por defecto, cuya funcionalidad escribe el nombre del paquete, seguido del nombre de la clase del objeto, seguido de "@", seguido de la dirección de memoria, en hexadecimal, del objeto. Por ejemplo:

```java
Práctica_1.Vacuna@50040f0c
```

Como esta información no es legible ni útil, se reescribe el método toString() para que nos diga "quién es" el objeto, cuáles son los valores de sus atributos.

### d) Cree otro objeto de tipo Vacuna y compárelo con el anterior. ¿Qué método de Object es utilizado para la comparación por contenido?

El método de object utilizado para la comparación por contenido es el `equals()`. Por defecto, funciona de la misma manera que comparar usando "==" o "!=", ambos chequean si el objeto de la izquierda está alojado en la misma dirección de memoria que el objeto de la derecha.

Debido a esto y como no sobreescribimos el método `equals()`, las comparaciones de objetos con los mismos valores para todos los atributos dan falso.

### e) Ejecute la aplicación fuera del entorno de desarrollo. ¿Para que se utiliza la variable de entorno CLASSPATH?

![Corriendo la aplicación en CMD](https://i.imgur.com/Kyqs8pX.png)

La variable de entorno CLASSPATH le dice al compilador de Java y a la Java Virtual Machine dónde encontrar las clases y los archivos Java ARchive (JAR) del programa, para que éste pueda compilar efectivamente nuestro programa.

### f) Construya un archivo jar con las clases anteriores, ejecútelo desde la línea de comandos. ¿Dónde se especifica en el archivo jar la clase que contiene el método main?

Para esto tenemos que hacer lo siguiente:

1. Compilar los archivos .java a archivos .class (ya lo hizo Eclipse).
2. Crear un archivo MANIFEST.MF con metadata del JAR, como la clase que contiene el método Main:

```
Manifest-Version: 1.0
Main-Class: Práctica_1.TestVacuna
linea vacía al final
```

3. Crear el archivo JAR: `jar cfm miapp.jar MANIFEST.MF -C bin .`
4. Verificar que se creó correctamente: `jar tf miapp.jar`
5. Ejecutar el JAR: `java -jar miapp.jar`

![Comandos](https://i.imgur.com/IySz5u7.png)
![Archivos JAR y MANIFEST](https://i.imgur.com/qgIbdBJ.png)

## 2. Analice las siguientes clases y responda cada uno de los incisos que figuran a continuación.

### a) Considere la siguiente clase Alpha. ¿Es válido el acceso de la clase Gamma? Justifique.

```java
package griego;

class Alpha {
    protected int x;
    protected void otroMetodoA() {
        System.out.println("Un método protegido");
    }
}

package griego;

class Gamma {
    void unMétodoG() {
        Alpha a = new Alpha();
        a.x = 10;
        a.otroMetodoA();
    }
}
```

✅ El código es válido y compilará sin problemas ya que las variables de instancia y métodos con especificador de acceso `protected` **son visibles para todas las clases que estén dentro del mismo paquete**. Como Alpha y Gamma están en el mismo paquete ("griego"), Gamma puede escribir directamente el valor del atributo x del objeto de clase Alpha, y también puede ejecutar su método "otroMetodoA" libremente.

### b) Considere la siguiente modificación de la clase Alpha. ¿Son válidos los accesos en la clase Beta? Justifique.

```java
package griego;

public class Alpha {
    public int x;
    public void unMetodoA() {
        System.out.println("Un Método Público");
    }
}

package romano;

import griego._;

class Beta {
    void unMetodoB() {
        Alpha a = new Alpha();
        a.x = 10;
        a.unMetodoA();
    }
}
```

✅ El código es válido y compilará sin problemas ya que las variables de instancia y métodos con especificador de acceso `public` **son visibles para todas las clases de cualquier paquete**. Como Alpha tiene una variable de intancia y un método públicos, Beta puede usarlos libremente.

### c) Modifique la clase Alpha como se indica debajo. ¿Es válido el método de la clase Beta? Justifique.

```java
package griego;

public class Alpha {
    int x;
    void unMetodoA() {
        System.out.println("Un mét. paquete");
    }
}

package romano;

import griego.\_;

class Beta {
    void unMetodoB() {
        Alpha a = new Alpha();
        a.x = 10;
        a.unMetodoA();
    }
}
```

❌ El código no es válido, ya que la variable de instancia y el método de la clase Alpha no tienen especificador de acceso, por ende tienen **por defecto acceso "Package", lo que significa que solo las clases de su mismo paquete (en este caso griego) tendrán acceso**. Como Beta está en otro paquete (romano) no puede acceder, y la sentencia `a.x = 10` lanzará una excepción.

### d) Considere el inciso c) ¿Es válido el acceso a la variable de instancia x y al método de instancia unMetodoA() desde una subclase de Alpha perteneciente al paquete romano? Justifique.

Si Alpha tiene una subclase que se encuentra en su mismo paquete, el paquete romano, entonces su subclase podrá acceder a la variable y el método de instancia sin problemas. Esto es porque el access modifier "Package" incluye a cualquier clase definida en el mismo paquete, incluidas las subclases.

### e) Analice el método de la clase Delta. ¿Es válido? Justifique analizando cómo influye el control de acceso protected en la herencia de clases.

```java
package griego;

public class Alpha {
    protected int x;
    protected void otroMetodoA() {
        System.out.println("Un método protegido");
    }
}

package romano;

import griego.*;

public class Delta extends Alpha {
    void unMetodoD(Alpha a, Delta d) {
        a.x = 10;
        d.x = 10;
        a.otroMetodoA();
        d.otroMetodoA();
    }
}
```

✅ El código es válido porque el especificador de acceso `protected` no solo provee acceso a todas las clases definidas dentro del mismo paquete, si no también a las subclases de esas clases incluso si están en otros paquetes.

## 3. Respecto de los constructores, analice los siguientes casos:

## 3.1. Escriba 3 subclases de la clase Vacuna (definida en el punto 1) llamadas VacunaPatogenoIntegro, VacunaSubunidadAntigenica y VacunaGenetica con las siguientes variables de instancias:

-   **VacunaPatogenoIntegro**: define una variable de instancia destinada para el nombre del virus patógeno inactivado o atenuado.
-   **VacunaSubunidadAntigenica**: define 2 variables de instancia, una para guardar la cantidad de antígenos de la vacuna y la otra para mantener el tipo de proceso llevado a cabo.
-   **VacunaGenetica**: define dos variables de instancia, una para la temperatura mínima y otra para la temperatura máxima de almacenamiento.

### a) Implemente los getters y setters para cada una de las variables de instancias anteriores.

Resuelto en Eclipse (proyecto Java "Práctica_1").

### b) Implemente los constructores para las clases anteriores, todos ellos deben recibir los parámetros necesarios para inicializar las variables de instancia propias de la clase donde están definidos.

Resuelto en Eclipse (proyecto Java "Práctica_1").

### c) ¿Pudo compilar las clases? ¿Qué problemas surgieron y por qué? ¿Cómo los solucionó?

❌ A priori no se pueden compilar las clases, ya que nos falta invocar el método `super(args)` dentro de los constructores de las subclases, y como argumentos pasar todos los demás atributos que las subclases heredan de Vacuna.

✅ Lo solucioné primero agregando en los 3 constructores de las 3 subclases los atributos que faltaban (los de la superclase Vacuna), y luego agregando la linea `super(args)` al principio de cada constructor.

## 3.2. El siguiente código, define una subclase de java.awt.Dialog. Verifique si compila. Si no lo hace implemente una solución. Nota: Recuerde que en esta [URL](https://docs.oracle.com/en/java/javase/19/docs/api/) tiene disponible la documentación de la API de java.

```java
package laboratorio;

import java.awt.Dialog;

public class Dialoguito extends Dialog {
    public Dialoguito() {
        System.out.println("Dialoguito") ;
    }
}
```

❌ El código no compilará porque Dialoguito es subclase de Dialog, pero en su constructor no llama al constructor de la superclase, con la sentencia `super()`.

✅ Se puede solucionar usando cualquiera de los constructores que tiene la superclase Dialog:

![Constructores de java.awt.Dialog](https://i.imgur.com/1HSKBJq.png)

Por ejemplo:

```java
package laboratorio;

import java.awt.Dialog;

public class Dialoguito extends Dialog {
    public Dialoguito(Frame owner) {
        super(owner)
        System.out.println("Dialoguito") ;
    }
}
```

## 3.3. Las clases definidas a continuación establecen una relación de herencia. La implementación dada, ¿es correcta?

### Constructores privados

```java
package laboratorio;

public class SuperClase {
    private SuperClase() {

    }
}

package laboratorio;

public class SubClase extends SuperClase {
    public SubClase() {

    }
}
```

❌ La implementación dada es errónea ya que los constructores de subclases, por más que no tengan la sentencia `super()`, la tienen de forma implícita. Esto significa que cuando un objeto de clase SubClase se intente crear, se ejecutará su constructor, el cual intentará ejecutar el constructor de su SuperClase, pero esto lanzará una excepción ya que el constructor de la SuperClase es **privado**.

### Constructores protegidos

```java
package laboratorio;

public class SuperClase {
    protected SuperClase() {

    }
}

package laboratorio1;

public class SubClase extends SuperClase {
    public SubClase() {

    }
}

package laboratorio1;

public class OtraClase {
    public OtraClase() {

    }
    public void getX() {
        new SuperClase();
    }
}
```

La implementación dada tiene partes correctas y partes erradas:

✅ SubClase se puede instanciar sin problema porque si bien el constructor de su SuperClase es `protected`, este especificador de acceso provee acceso a sus subclases, incluso si están en otros paquetes, como en este ejemplo.

❌ Luego de que se instancia un objeto de la clase OtraClase, y este objeto intenta ejecutar su método getX(), se lanzará una excepción. Esto es porque, como OtraClase está en un package diferente a SuperClase, no se puede instanciar un objeto de esta clase en el método getX().

## 4. Hay un número de casos donde se necesita tener una única instancia por clase, esto es lo que se conoce como el patrón Singleton. Implemente una clase que cumpla con este patrón llamada PoolConexiones, la misma debe proveer una manera para acceder a esa instancia. Piense en los modificadores de acceso del constructor y en los calificadores java que tiene disponibles, para buscar una solución.

Resuelto en Eclipse (proyecto Java "Práctica_1").

Básicamente, funciona de la siguiente manera:

1. Usamos un constructor `private` para que solo la misma clase pueda crear la única instancia.
2. Agregamos un atributo privado y estático del mismo tipo que el nombre de la clase, este atributo alojará la única instancia (o null si aún no fue creada).
3. Agregamos un método estático que crea la única instancia de forma interna, o la devuelve si ya fue creada.

## 5. Escriba las siguientes clases java que figuran en el siguiente diagrama UML respetando cada una de las especificaciones para las clases y las relaciones entre ellas:

![Diagrama UML](https://i.imgur.com/M0PTIFF.png)

Tenga en cuenta lo siguiente:

-   La clase **FiguraGeometrica** es una **clase abstracta** con 2 métodos abstractos **dibujar()** y **area()** y el resto de los métodos concretos.
-   Las subclases **Rectangulo** y **Circulo** son clases concretas. Ambas deben implementar el método **dibujar()** simplemente imprimiendo un mensaje en la consola. Por ejemplo: “se dibuja un círculo de radio 2 y de color azul” (donde el radio y el color son variables de instancia). El método **area()** debe implementarse en cada subclase de **FiguraGeometrica**.
-   En la clase **Paint**, el método **init()** debe crear las instancias de **Rectangulo** y **Circulo** y guardarlas en el arreglo paleta. Los valores para crear estas instancias son los siguientes:
    -   Defina 2 objetos Circulo (radio 2 y color azul, radio 3 y color amarillo)
    -   Defina 2 objetos Rectangulo (alto 2, ancho 3, color verde y alto 4 y ancho 10 y color rojo).
-   La clase **PaintTest** debe crear una instancia de **Paint**, inicializarla y recorrerla. En cada iteración invoque el método **area()** sobre el elemento actual y **getRadio()**, sólo si se trata de un objeto de tipo **Circulo**.
-   Construya un archivo jar ejecutable con las clases anteriores. El mismo debe poderse ejecutar como un programa haciendo doble click.

Resuelto en Eclipse (proyecto Java "Práctica_1").

![Output ejercicio 5](https://i.imgur.com/vG4ZnMS.png)

![JAR y MANIFEST.MF ejercicio 5](https://i.imgur.com/vE23pnR.png)
