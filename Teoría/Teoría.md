<h1 align="center">Clase 1 - 21 de agosto, 2024</h1>

## Plataformas de ejecución

-   Una plataforma es un sistema formado por un **hardware** (arquitectura) y un **sistema operativo** (también ciertas librerías de ejecución) sobre el que una aplicación, programa o proceso se ejecuta.
-   Es el hardware y el software usado para hostear aplicaciones o servicios. Se podría definir como el **escenario sobre el que se ejecutan los programas**.
-   Una plataforma cumple con un conjunto de estándares que permite a los desarrolladores de software desarrollar aplicaciones para dicha plataforma.

## Java

### Introducción

-   Java se divide en dos: **una plataforma de software** y un **lenguaje de programación**.
-   James Gosling diseñó JAVA a principios de los 90, e implementó el compilador JAVA y la JVM (Java Virtual Machine).
-   Actualmente, el diseño de la plataforma está bajo control de una comunidad de empresas tecnológicas llamada [Java Community Process (JCP)](http://jcp.org/en/home/index).
    -   La JCP desarrolla especificaciones de tecnologías JAVA.
    -   Contar con una especificación transforma a todas las tecnologías JAVA en estándares.
    -   Cada fabricante de software desarrolla su implementación respetando la especificación.
    -   De esta manera se garantiza compatibilidad y portabilidad.
-   La plataforma JAVA se divide en tres: JSE, JEE, JME.

### Java Standard Edition

-   Está diseñado para aplicaciones de escritorio.
-   Se ejecuta sobre todos los SO.
-   Provee la infraestructura de compilación y de ejecución a través de la máquina virtual y las API básicas.
-   Se compone de una plataforma de ejecución llamada **JRE** y una de desarrollo llamada **JDK**.
    -   Java Runtime Environment (JRE) está compuesto por librerías de componentes de software (JAVA API), la Máquina Virtual (HotSpot VM) y otras componentes necesarias para ejecutar y desplegar aplicaciones de escritorio escritas en JAVA.
    -   Java SE Development Kit (JDK) es un superconjunto de JRE, contiene todo lo que está en JRE + herramientas de desarrollo como un compilador, debugger, compactador, documentador, necesarios para desarrollar aplicaciones de escritorio. Herramientas de seguridad, de deployment, etc.
-   La API JSE ofrece la funcionalidad principal del lenguaje JAVA, define todos los tipos básicos y objetos JAVA hasta clases de alto nivel para ser usadas en conectividad, seguridad, acceso a BD, desarrollo de GUI, parsing XML, etc.
-   [OpenJDK](http://openjdk.java.net/) es la única implementación de Java SE de **código abierto**.
-   Componentes de la plataforma JSE:
    ![Componentes de la plataforma JSE](https://i.imgur.com/c0SMDyU.png)

-   La virtual machine HotSpot implementa la especificación de la JVM y se distribuye junto al JRE. Es la JVM predeterminada desde la versión 1.3 del JSE. Usa compilación dinámica que adaptativamente compila bytecodes a instrucciones de máquina especificas de forma optimizada. La plataforma JSE contiene 2 implementaciones de la VM HotSpot: HotSpot Client VM y HotSpot Server VM.
-   La plataforma JSE es usada en una amplia variedad de herramientas, entre ellas: IDEs, herramientas de testeo, de monitoreo de performance, servidores de aplicaciones, etc:

| IDE                        | Software libre y código abierto | Propietario |
| -------------------------- | ------------------------------- | ----------- |
| Eclipse                    | ✔                               | ❌          |
| NetBeans                   | ✔                               | ❌          |
| IntelliJ IDEA              | ✔                               | ✔           |
| BlueJ                      | ✔                               | ❌          |
| Android Studio (no es JSE) | ✔                               | ❌          |
| Oracle JDeveloper          | ❌                              | ✔           |

### Java Enterprise Edition

-   Java del lado del servidor.
-   Actualmente se llama Jakarta EE y su desarrollo es liderado por Eclipse Foundation y **no por la JCP**.

### Java Micro Edition

-   Es una versión simplificada de JSE para dispositivos móviles.
-   La falta de acceso al hardware del dispositivo y la ejecución en un entorno controlado (sandbox) da como resultado que **las aplicaciones JME no aprovechan las ventajas propias del mundo móvil**.
-   NO fue adoptada como plataforma de desarrollo de aplicaciones móviles nativas.
-   **Android es la plataforma de desarrollo y ejecución de aplicaciones móviles nativas en JAVA y KOTLIN**.

### La Plataforma Java

1. Java es un lenguaje de programación.
2. Los programas escritos en Java pueden funcionar en diferentes tipos de computadoras y sistemas operativos sin necesidad de cambiar el código. Esto se debe a que Java está diseñado para ser independiente del hardware y del sistema operativo.
3. Para que los programas Java se ejecuten, necesitan una plataforma especial llamada JRE (Java Runtime Environment). La JRE es un entorno que proporciona todo lo necesario para ejecutar los programas Java.
4. Dentro de la JRE, hay un componente crucial llamado JVM (Java Virtual Machine). La JVM es un traductor que convierte el código Java en instrucciones que la computadora puede entender y ejecutar.
5. La JSE es la plataforma que ofrece herramientas y bibliotecas que los programadores utilizan para escribir y desarrollar programas Java sin reinventar la rueda.

### Java Runtime Environment

-   Es la plataforma de ejecución de los programas escritos en Java.
-   Se compone de dos piezas fundamentales:

1. Java Virtual Machine (JVM): es el corazón de la plataforma JAVA y es compatible con todos los sistemas operativos.
2. Java Application Programming Interface (Java API): Es una colección de componentes de software (archivos .class) que proveen una amplia gama de funcionalidades, como GUIs, I/O, colecciones, networking, etc.

### Java Virtual Machine

#### Introducción

-   Es una máquina de software que emula una máquina real, es decir es una "computadora abstracta" definida por una especificación única.
-   La especificación de la JVM permite que el software Java sea “independiente de la plataforma” ya que se compila para una máquina genérica o JVM. De esta forma, aísla al programa Java del sistema operativo y del hardware sobre el que se ejecuta.
-   La especificación de la JVM provee un estándar.
-   La JVM es la que garantiza la gran portabilidad del código Java.
-   Cada S.O. tiene su **propia implementación de la JVM**.
-   La especificación de la JVM provee definiciones para:
    -   El conjunto de instrucciones (es un equivalente al conjunto de instrucciones de la CPU).
    -   El conjunto de registros de máquina.
    -   El formato de archivos .class.
    -   La pila de ejecución.
    -   Una heap con garbage-collection.
    -   Un área de memoria donde instalarse.
-   El compilador JAVA toma un **archivo fuente .java** y genera un **archivo de bytecodes .class**. Los bytecodes son instrucciones de código de máquina para la JVM.

#### Funcionamiento

-   Su funcionamiento fue modificado a través del tiempo:

    1. La JVM original interpretaba los bytecodes línea a línea y los traducía a código de máquina.
    2. La segunda generación de JVM agregó un compilador JIT (Just In Time) que compila cada método a código nativo ante la primera invocación y luego ejecuta el código nativo. Luego, cada vez que el método es invocado, se ejecuta el código nativo.
    3. La JVM actual, Java HotSpot, es un híbrido entre de las 2 técnicas: combina interpretación de bytecodes con compilación en ejecución a código nativo.

-   Posee dos componentes principales:

    1. **Class Loader**: El Class Loader carga todas las clases necesarias para la ejecución de un programa, utilizando espacios de nombres separados para diferentes clases del sistema de archivos. Prioriza las clases locales para evitar alteraciones y añade protección adicional en la memoria.
    2. **Verificador de Bytecodes**: El verificador garantiza que los bytecodes siguen el formato correcto y que se mantiene la integridad del sistema, previniendo diversas formas de violaciones de seguridad.

-   Su funcionamiento actual es el siguiente:

    1. **Cargar los bytecodes en memoria**: El Class Loader, un subsistema de la JVM, se encarga de cargar en memoria las clases necesarias del programa, incluyendo las clases del usuario y las de la API de Java.
    2. **Verificación del bytecode**: El Verificador de Bytecodes asegura que los bytecodes cumplen con las especificaciones del JVM, evitando violaciones como la manipulación ilegal de punteros o el acceso no autorizado al sistema de archivos.
    3. **Ejecutar los bytecodes**: Un subsistema de ejecución de la JVM que funciona como motor de ejecución es el que se encarga de ejecutar los bytecodes. Originalmente, esto se hacía mediante un intérprete. Con el tiempo, se introdujo el compilador Just-In-Time (JIT), que traduce los bytecodes a código nativo la primera vez que se ejecutan y luego los guarda en caché para su reutilización. La VM HotSpot es un optimizador adaptativo que optimiza los métodos más utilizados.

-   Su funcionamiento gráficamente:

![Funcionamiento JVM 1](https://i.imgur.com/giNWJeD.png)
![Funcionamiento JVM 2](https://i.imgur.com/x3gItLc.png)

### Java API

-   La Application Programming Interface (API) de Java es un conjunto de librerías de clases e interfaces compiladas, listas para ser usadas, organizadas en paquetes, que forman parte de la distribución JSE.
-   Algunos de los paquetes de la API más usados son:

    1. `java.lang`: manejo de cosas esenciales como números, strings, objetos, compilador, run-time, seguridad y threads (es el único paquete que se incluye en todo programa Java de forma automática)
    2. `java.io`: manejo de entrada/salida, serialización de objetos.
    3. `java.util`: manejo de estructuras de datos, fechas, hora, excepciones, etc.
    4. `java.net`: contiene clases como URL, TCP, UDP, IP, etc. que permiten implementar aplicaciones distribuidas. Provee soporte para sockets.
    5. `java.awt`: manejo de GUIs, pintar gráficos e imágenes.
    6. `java.awt.image`: manejo de imágenes.
    7. `java.sql`: manejo de base de datos relacionales (JDBC, JDBC-ODBC).
    8. `java.security`: contiene clases e interfaces para manejar seguridad (criptografía, firmas digitales, encriptación y autenticación).

### Android vs Java vs Kotlin

-   Android es un sistema operativo de **código fuente abierto** controlado por Google para dispositivos móviles **basado en el núcleo de Linux**. Actualmente está presente en una amplia gama de dispositivos: Android WEAR, Android AUTO, Android TV, etc.
-   Windows Mobile y iPhone de Apple ofrecen un rico entorno de desarrollo para aplicaciones móviles. Sin embargo, a diferencia de Android, están **basados en sistemas operativos propietarios** que frecuentemente dan prioridad a las aplicaciones nativas sobre las creadas por terceras partes y restringe la comunicación entre las aplicaciones y los datos nativos de teléfono.
-   Android ofrece nuevas posibilidades para aplicaciones móviles al estar basado en un entorno de desarrollo **abierto** como Linux. El acceso al hardware está disponible para todas las aplicaciones a través de una serie de APIs y soporta interacción entre aplicaciones.
-   Las aplicaciones nativas en Android se pueden **escribir en JAVA o Kotlin**, sin embargo Google anunció en 2019 que **Kotlin es el lenguaje preferido para desarrollar aplicaciones nativas en Android**. Kotlin es totalmente interoperable con Java.

## Paquetes

### Introducción

-   En Java, un Paquete es una **colección nombrada de componentes de software** que pueden ser clases, interfaces, enums, anotaciones, etc.
-   Se usan para **agrupar componentes de software que están relacionados entre sí** y definir un **espacio de nombres común a las entidades contenidas** dentro del paquete.
-   Las clases e interfaces core de Java están en un paquete cuyo nombre comienza con java y luego subnombres de forma jerárquica (`java.lang`, `java.util`, etc).
-   Esta jerarquía funciona porque los paquetes pueden contener sub-paquetes como por ejemplo `java.awt` -> `java.awtevent` y `java.awt.image`.
-   Las extensiones de la plataforma Java están disponibles a través de **módulos** cuyos nombres empiezan con **jdk**, por ej paquetes estándar como org.w3c.dom.html que implementan estándares que define la W3C está incluido en el módulo jdk.xml.dom.
-   Todas las clases, interfaces, enums y anotaciones tienen un **nombre simple y un nombre completo**.
    -   El nombre simple es el que usamos para definir a la clase. Por ejemplo, la clase String tiene nombre simple **String**.
    -   El nombre completo es el que incluye como prefijo al nombre del paquete donde está alojada la clase. Por ejemplo, la clase String tiene nombre completo `java.lang.String`.

### Nombres únicos de paquetes

-   Los paquetes dividen el espacio de nombres global de Java y evitan colisiones de nombres entre clases. Por ejemplo, el nombre del paquete nos permite diferenciar la **interface `java.util.List`** de la **clase `java.awt.List`**.
-   La práctica que sigue Java respecto a los nombres de los paquetes y la jerarquía es ir de lo más general a lo más específico. Es decir, por ejemplo: paqueteGeneral.paqueteEspecifico.paqueteMásEspecífico.
-   Pautas para elegir nombres únicos de paquetes:
    -   Si somos desarrolladores de clases que serán usadas por otros programadores y que las combinarán con múltiples clases desconocidas por nosotros, es importante que los nombres de los paquetes sean **globalmente únicos**. Por ej. desarrolladores de compañías de software, de comunidades de software libre, etc.
    -   Si estamos desarrollando una aplicación JAVA cuyas clases no serán usadas por otros programadores fuera de nuestro equipo de trabajo, podemos elegir el **esquema de nombres de paquetes que mejor nos parezca**. En este caso conocemos el nombre completo del conjunto de clases que nuestra aplicación necesita para el deployment y no tendremos imprevistos por conflictos de nombres.

### Palabra clave package

-   En Java las clases e interfaces típicamente se agrupan en paquetes usando como primer token del archivo fuente la palabra clave package seguido por el nombre del paquete.

```java
package.ar.com.laplataautos;

public class Vehiculo {
    private String marca;
    private String nroMotor;

    public String getMarca() {
        return marca;
    }

    public string getNroMotor() {
        return nroMotor;
    }
}
```

-   Si se omite la palabra package al definir una clase, ésta se guardará en el **default package**, lo cual es una mala práctica.

### Importar tipos de datos

-   El mecanismo predeterminado para usar clases o interfaces es usar su **nombre completo**. Por ejemplo si queremos usar la clase `java.io.File`, escribimos esto mismo cada vez que la referenciamos.
-   Como esto es muy tedioso y poco legible, podemos usar otros mecanismos según el caso:

1. Si queremos usar una clase del paquete `java.lang`, la podemos usar directamente, sin necesidad de escribir java.lang.Clase.
2. Si queremos usar una clase del mismo paquete donde estamos trabajando, la podemos usar directamente.
3. Si queremos usar una clase de otro paquete que no sea `java.lang`, podemos usar la sentencia `import` para luego poder usar la clase directamente, con su **nombre simple**:

```java
import ar.edu.unlp.linti.graficos.Rectangulo;
import java.io.File;
import java.io.*; // 1. No importa subpaquetes. 2. Importa solo los tipos que se referencian en el código.
```

### Colisión de nombres

-   La sentencia `import` puede tener problemas si:

    1. Importamos "todo" (\*) de dos paquetes que tienen una o más clases/interfaces llamadas igual.

    ```java
    import java.util.*;
    import java.awt.*;
    // Causan conflicto por ejemplo con la interfaz vs clase List.
    ```

    2. Importamos dos clases/interfaces distintas pero que se llaman igual, de dos paquetes distintos.

    ```java
    import java.util.List;
    import java.awt.List;
    ```

-   Esto se puede solucionar usando el nombre simple para una de las clases/interfaces, y el nombre completo para la otra.

### Importar miembros estáticos

-   Se puede importar miembros estáticos de clases e interfaces usando `import static`, ya sea para importar un solo miembro, o todos (\*).
-   Esto resulta útil primero para acortar nuestro código y hacerlo más legible (por ejemplo hacer `out.println()` en vez de `System.out.println()`) y también para evitar usar Package.Método cada vez que queremos usar un método de una clase estática.

### Ubicación de paquetes

-   Un paquete está formado por muchos archivos .class.
-   Java aprovecha la estructura jerárquica del filesystem del SO y ubica todos los .class de un paquete en una misma carpeta en el sistema de archivos. Por ejemplo:

```java
package ar.edu.unlp.linti.graficos;

import java.awt.*;

public class Rectangulo extends Graphics implements Draggable {

}
// Esta clase se encuentra en el path ar/edu/unlp/linti/graficos/Rectangulo.class
```

### Archivos JAR

-   Es posible agrupar muchos paquetes en un solo archivo usando los archivos JAR (Java ARchive).
-   Los JAR usan el formato ZIP. Son archivos multiplataforma, totalmente portables.
-   Además de .class, pueden incluirse imágenes, audio, etc.
-   También contienen un archivo MANIFEST.MF ubicado en META-INF/MANIFEST.MF que indica cómo se usa el archivo JAR. Las aplicaciones desktop, a diferencia de las librerías, requieren que el archivo MANIFEST.MF contenga una entrada con el **nombre de la clase que actuará como punto de entrada de la aplicación**, la que define el método `main()`.
-   La distribución estándar del JSE contiene una herramienta que permite crear archivos JAR desde cmd: `jar`.
-   El intérprete Java busca, descompacta, carga y ejecuta los .class contenidos en el JAR.
-   Estos archivos son la opción recomendada para entregar aplicaciones o librerías. Esto es porque una app empaquetada en un JAR es un **archivo ejecutable Java** que se puede abrir directamente desde el SO.

## Especificadores de acceso

### Introducción

-   Java posee varios especificadores de acceso que **determinan el acceso a clases, interfaces, métodos, atributos y constructores según distintos niveles de ocultamiento**.
-   Estos especificadores son extremadamente importantes ya que uno de los factores más importantes que distingue un módulo bien diseñado de uno mal diseñado es el nivel de **ocultamiento de sus datos y de otros detalles de implementación**. Un módulo bien diseñado **oculta a los restantes módulos del sistema todos los detalles de implementación separando su interface pública de su implementación**. Estos especificadores ayudan con el desacoplamiento y la alta reusabilidad del código.
-   Los E.A de Java son, del menos restrictivo al más restrictivo: `public` → `protected` → `package` (no tiene palabra clave) → `private`.
-   Si no se tiene ninguna de ellas, Java asume especificador package.
-   Los E.A se ubican delante (antes) de la definición de cada variable, método, constructor, clase o interface.

### Public

-   Una clase declarada `public` es parte de la API que se exporta y está disponible mediante la cláusula `import`.

### Protected

-   La palabra clave `protected` está relacionada con la herencia.
-   Si se define una subclase en un **paquete diferente al de la superclase**, la subclase solo tiene acceso a los miembros definidos `public`.
-   Si se define una subclase en el **mismo paquete que la superclase**, la subclase tiene acceso a todos los miembros declarados `public` y `package`.
-   El autor de la clase base podría determinar qué miembros pueden ser accedidos por las subclases, pero no por todo el mundo. Esto es `protected`.
-   Además el acceso `protected` provee acceso `package`: las clases declaradas en el mismo paquete que el miembro `protected` tienen acceso a dicho miembro.

### Package

-   Si un miembro de una clase no posee ningun especificador de acceso, entonces tiene acceso por defecto, y comúnmente se lo llama acceso package o friendly o privado del paquete.
-   Implica que tienen **acceso a dicho miembro solamente las clases ubicadas en el mismo paquete que él**.
-   Para las clases declaradas en otro paquete, es un miembro privado.
-   El acceso `package` le da sentido a agrupar clases en un paquete.

### Private

-   Las variables, métodos y constructores declarados `private` **solamente están accesibles para la clase que los contiene**. Están disponibles para usar dentro de los métodos de dicha clase.
-   Una buena práctica es declarar todo `private` siempre que se pueda.

### Control de acceso y herencia

-   Java establece que una subclase hereda de sus superclases todos los atributos y métodos de instancia **accesibles**:
    -   Si la subclase está definida en el **mismo paquete** que la superclase, hereda todos los atributos y métodos de instancia **que no sean privados**.
    -   Si la subclase está definida en un **paquete diferente** que la superclase, hereda solamente los atributos y métodos de instancia **protegidos y públicos**.
    -   Los atributos y métodos de instancia **privados nunca se heredan**.
-   Los constructores no se heredan, **se encadenan**.

---

<h1 align="center">Clase 2 - ? de ?, 2024</h1>

##

---

<h1 align="center">Clase 3 - ? de ?, 2024</h1>

##

---

<h1 align="center">Clase 4 - ? de ?, 2024</h1>

##

---
