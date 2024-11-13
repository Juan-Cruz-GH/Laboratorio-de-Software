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

<h1 align="center">Clase 2 - 28 de agosto, 2024</h1>

## Clase Object

### Método equals()

-   Por defecto, este método retorna V o F cuando dos objetos apuntan a la misma dirección de memoria.
-   Como este comportamiento no suele ser útil, se suele sobreescribir este método en las clases con implementaciones personalizadas del mismo, por ejemplo comparando si un objeto posee los mismos valores que otro en todas sus variables de instancia.
-   Dicho de otra forma, se recomienda sobreescribir este método cuando las instancias de una clase tienen una **noción de igualdad lógica que difiere de la identidad o referencias de esas instancias**. Este es generalmente el caso de clases que representan valores, como por ejemplo las clases Integer, String de la API de JAVA.

### Método hashCode()

-   Retorna un código de hasheo HEX asociado a la dirección de memoria donde está alojado el objeto.
-   Este método se debe sobreescribir siempre que se haya sobreescrito el `equals()` y tengamos objetos que serán alojados en colecciones basadas en hashing como HashMap, HashSet, HashTable.
-   Esto es porque una correcta sobrescritura del método hashCode() asegura que dos instancias lógicamente iguales tengan el mismo hashcode y en consecuencia las estructuras de datos basadas en hashing que almacenan y recuperan estos objetos, funcionarán correcta y eficientemente.
-   Dicho esto, incluso si no usamos estas colecciones, sigue siendo buena práctica sobreescribir el `hashCode()` siempre que hayamos sobreescrito el `equals()` para que se respete la lógica: si dos objetos son iguales según el método `equals()` entonces invocar al método `hashCode()` sobre cada uno de estos objetos, debe producir el **mismo valor**.

### Método toString()

-   Retorna un string formado por el nombre completo de la clase, seguido de @ más la representación HEX del código hash del objeto.
-   Este método se invoca implícitamente en los métodos `print()`, `println()`, etc.
-   Es una buena práctica sobreesscribir el método `toString()` para devolver un string que represente de forma más amigable al objeto en cuestión.

## Herencia

### Introducción

-   La herencia permite crear una clase nueva como un **subtipo** de una clase.
-   La subclase **hereda** de su superclase todos sus métodos y variables de instancia que no **sean privados**.
-   En Java, el compilador hace un montón de cosas relacionadas a la herencia implícitamente.
-   La herencia solo es **apropiada cuando existe una relación de subtipo genuina** entre la subclase y la superclae.
-   Es **"seguro"** usar herencia dentro de un paquete donde las implementaciones de subclase y superclase están bajo el control de los mismos developers. Cuando este no es el caso, se puede generar "fragilidad de código" y otros problemas.

### Encadenamiento de constructores

-   Un objeto de la subclase incluye un objeto de la clase padre.
-   Como es esencial que el objeto de la subclase se inicialice correctamente, el constructor de la subclase siempre invoca al constructor de la superclase.
-   Si la superclase a su vez es una subclase de otra superclase, se sigue la cadena: se invocan todos los constructores de la cadena de herencia.
-   El compilador Java silenciosamente invoca al constructor nulo o de default de la clase base en el constructor de la clase derivada (si no se lo invocó explícitamente). La invocación es automática.
-   Relacionado a lo anterior, hay una restricción: si una clase define constructores con argumentos y NO define al constructor nulo, **todas sus subclases deben definir constructores que invoquen explícitamente a los constructores con argumentos**, o se producirá un error de compilación.
-   Como todas las clases heredan de Object implícitamente, la última clase en la cadena de herencia invoca al constructor de Object.
-   Un constructor invoca al constructor de su superclase con el método `super()`.

### Upcasting - Polimorfismo

-   Java soporta la relación "es un" entre la clase derivada y la clase base. Por ejemplo, si tenemos de clase derivada Perro y clase base Animal → Perro es un Animal.
-   El Upcasting es la **conversión de la referencia a un objeto de la clase derivada en una referencia a un objeto de la clase base**.
-   El Upcasting es seguro: la clase derivada es un super conjunto de la clase base, podría contener más métodos que la clase base, pero seguro contiene los métodos de la clase base.

### Polimorfismo

-   El polimorfismo en Java se logra vía **binding dinámico**, que es la asociación entre la invocación a un método y el código que se ejecutará. Básicamente, el compilador busca el tipo real del objeto y ejecuta el método de su clase, no de su superclase, por más que ambos métodos se llamen igual.
-   Todos los métodos de una clase `final` (una clase `final` tiene todos sus métodos `final` implicitamente), todos los métodos declarados `final`, `private` o `static` son invocados **sin usar Dynamic Binding**. Las invocaciones a estos métodos son candidatas a ser optimizadas (por ej. usar inlining).

### Sobreescritura de métodos

-   Cualquier método que se herede (siempre que no sea privado ni final) de una superclase puede ser sobreescrito en las subclases.
-   Los métodos sobreescritos en una subclase deben tener el mismo nombre, la misma lista de argumentos (en cuanto a tipo y orden) y el mismo tipo de retorno que los declarados en la superclase. El tipo de retorno es covariante, de esta manera el tipo de retorno puede ser una subclase del tipo de retorno del método original.
-   El **nivel de acceso de un método sobreescrito debe ser igual o menos restrictivo que el declarado en la superclase**. Por ejemplo: si en la superclase el método es declarado `public` entonces el método sobreescrito en la subclase debe declararse `public`. Si en la superclase el método es declarado `protected` o `default`, en la subclase puede declararse `public`.
-   Las excepciones son clases especializadas que representan errores que pueden ocurrir durante la ejecución de un método. Los métodos sobreescritos deben disparar **las mismas excepciones o subclases de las excepciones disparadas por el método original**. No pueden disparar otras excepciones.

### Constructores y polimorfismo

-   Los constructores en Java no son polimórficos. Son implícitamente `static`.
-   Buena práctica para constructores:
    -   Los constructores no deben invocar a métodos que fueron sobreescritos.
    -   Los únicos métodos que son **seguros** para invocar en el cuerpo de un constructor son los declarados `final` en la clase base o `private` (que son automáticamente `final`). Estos métodos no pueden sobreescribirse y por lo tanto funcionan correctamente.

### Ocultar atributos de la superclase

-   Cuando una subclase declara un atributo con el mismo tipo y nombre que uno de la superclase, está "ocultando" el atributo que hereda de su superclase.
-   Esto significa que cuando la subclase manipula esta variable de instancia con `variable = X` o `this.variable = X`, se está refiriendo a SU variable de instancia, y no la que heredó. Solo podemos referirnos a la variable de la superclase con `super.variable = X`.
-   Esto mismo se puede hacer también con variables de clase.
-   Los métodos de clase de la misma manera que los atributos pueden ocultarse por una subclase, **pero NO sobreescribirse**. NO son un reemplazo.

## Clases abstractas

-   Son clases no instanciables pero extendibles.
-   Representan un concepto abstracto, expresan la interface de un objeto y no una implementación particular.
-   Se declaran con `abstract class Clase`.
-   Pueden tener métodos abstractos y métodos con implementación.
-   Los métodos abstractos solo poseen declaración y carecen de cuerpo: `abstract void unMétodoAbstracto();`.
-   Una clase que posea al menos un método abstracto **debe** declararse `abstract` o el programa no compilará.
-   Las clases que extienden de una clase `abstract` **deben** proveer una implementación concreta para todos los métodos abstractos de la clase `abstract`. Caso contrario, el programa no compila.

## Interfaces

### Introducción

-   Una interface es un dispositivo o sistema que permite a entidades no relacionadas interactuar entre sí.
-   Es una colección de definiciones de métodos sin implementación y de declaraciones de constantes agrupadas bajo un nombre.
-   Son abstractas.
-   Definen un tipo de dato, por lo tanto es posible declarar variables con el nombre de la interface por más que no se puedan instanciar. Ejemplo: `Centrable c;`, donde c hace referencia a un objeto de cualquier clase que implemente la interface `Centrable`.
-   No proveen implementación para los tipos que definen, si no un mecanismo de herencia de comportamiento.
-   No son instanciables.
-   Las clases pueden implementar interfaces: cuando lo hacen tienen disponible las constantes declaradas en la interface y deben implementar cada uno de los métodos declarados en la interface. Una instancia de dicha clase es del tipo de la clase y de la interface.
-   Las interfaces permiten que objetos que no comparten la misma jerarquía de herencia sean del mismo tipo en virtud de implementar la misma interface.
-   Una interface no puede definir variables de instancia. Las variables de instancia son detalles de implementación y las interfaces son una especificación sin implementación. Las únicas variables permitidas en la definición de una interface son constantes de clase, que se declaran `static` y `final`.

### Sintaxis

```java
interface nombreInterface extends superInterface1, superInterface2, superInterfaceN {
    // Declaración de métodos: implícitamente public abstract
    // Declaración de constantes: implícitamente public static final
}
```

### Especificadores de acceso

-   El especificador de acceso public establece que la interface puede ser usada por cualquier clase o interface de cualquier paquete, es parte de la API que se exporta.
-   Si se omite el especificador de acceso, la interface solamente puede ser usada por las clases e interfaces contenidas en el mismo paquete que la interface declarada, visibilidad de `package`, NO es parte de la API que se exporta, es parte de la implementación.

### Estructura interna

-   Las interfaces poseen métodos, que son siempre `public abstract`, y constantes, que son siempre `public static final`.

### Herencia

-   Una interface puede extender de múltiples interfaces. Por lo tanto se tiene **herencia múltiple de interfaces**.
-   No existe una interface de la cual todas las interfaces sean extensiones: **no hay un análogo a la clase Object en interfaces**.
-   Las interfaces proveen una alternativa limitada y poderosa a la herencia múltiple. **Las clases en JAVA pueden heredar de una única clase pero pueden implementar múltiples interfaces**.
-   Una interface hereda todas las constantes y métodos de sus superInterfaces, y puede definir nuevos métodos y constantes propios.
-   Una clase que implementa una interface debe implementar todos los métodos abstractos definidos por la interface, **así como todos los métodos abstractos heredados de las superinterfaces de esa interface**.

### Sobreescritura

-   La declaración de un método en una interface sobreescribe a todos aquellos que tienen la misma firma que en sus superinterfaces.
-   Hay error de compilación si el tipo de retorno del método sobreescrito no es subtipo del retornado por el método original.
-   El método sobreescrito no debe tener claúsulas throws que causen conflicto con alguno de los métodos que sobreescribe.

### Colisión de nombres

```java
public interface B {
    int W = 5;
}

public interface C {
    int W = 10;
}

public interface A extends B, C {
    int Z = J * W + 5;
}
```

-   Se produce un error por haber ambiguedad en cuanto a qué "W" se está referenciando en la interface A, si la heredada de la interface B o la C.
-   Se soluciona usando el nombre completo del atributo.

### Métodos default a partir de Java 8

-   Antes de Java 8, si se agregaba un método nuevo a una interface que una clase implementaba, ahora esa clase ya no podía compilar por no haber implementado este nuevo método. Esto trajo problemas ya que se tendría que actualizar la interface y todas las clases que implementan esa interface "al mismo tiempo" lo cual no es viable en proyectos grandes.
-   Java 8 solucionó esto incoporando métodos default/defender/virtuales.
-   Los métodos default contienen una implementación predeterminada que utilizan todas las clases que implementan la interface y que no implementan el método de default.
-   Sin embargo, se recomienda evitar el uso de este tipo de métodos.

## Interfaces vs clases abstractas

-   Las interfaces y las clases abstractas proveen una interface de comportamiento común.
-   A partir de JAVA 8, las interfaces pueden proveer **implementaciones para algunos métodos de instancia**. En este sentido podríamos decir que tanto las interfaces como las clases abstractas proveen herencia de comportamiento y de implementación.
-   En ninguna de las dos se puede crear instancias.
-   Para implementar un tipo definido por una clase abstracta es necesario extender a la clase abstracta, **se fuerza una relación de herencia**. Sin embargo, **cualquier clase puede implementar una interface** independientemente de la jerarquía de herencia a la que pertenezca.
-   Las interfaces son ideales para definir “mezclas”: una "mezcla" es un tipo que una clase puede implementar además de su tipo primario. Ejemplo: La interface Comparable permite que una funcionalidad (ordenación) se pueda mezclar con su función primaria. Con clases abstractas no pueden definir este tipo de comportamiento.
-   Agregar nuevas definiciones de métodos en interfaces que forman parte de la API pública ocasiona problemas de incompatibilidad con el código existente. Las clases abstractas pueden agregar métodos no-abstractos sin romper el código de las clases que las extienden (a veces lo rompen). JAVA 8 soluciona el problema de incompatilidad de las interfaces (polémico?).
-   En algunas situaciones la elección es de diseño.
-   Es posible **combinar** clases abstractas e interfaces: **definir un tipo como una interface y luego una clase abstracta que la implementa parcialmente, proveyendo implementaciones por defecto que las subclases aprovecharán (skeletal implementation)**. Patrón Template Method.

<h1 align="center">Clase 3 - 4 de septiembre, 2024</h1>

## Clases anidadas

### Introducción

-   Las clases anidadas son clases **definidas dentro de otras clases**.
-   Solo sirven para la clase donde están definidas, por fuera "no existen".
-   Pueden ser `private` o `protected`. Si son private, solo son accesibles por su clase contenedora (pero no serían accesibles para otras clases anidadas dentro de esa misma clase contenedora).
-   Tienen acceso a toda la implementación de la clase que las contiene (variables de instancia, variables de clase, y métodos) incluso si son `private`.
-   Son similares a los métodos de instancia/variables de instancia. Sus instancias se asocian a cada instancia de la clase que las contiene.

### Alternativa

-   Podemos ocultar una clase **sin usar clases anidadas** definiendo a una clase con acceso default/package, de modo que solo será visible dentro del paquete donde se declaró.

### Usos

-   Las clases anidadas se usan para ocultar detalles de implementación.
-   En el framework de colecciones de Java, se usan clases anidadas para implementar:
    -   **Iterators**, que acceden a los elementos de la colección secuencialmente sin exponer la representación interna. Se usan en List y Set.
    -   **Adapters**, que permiten a las implementaciones de Map implementar sus vistas de colección, mediante métodos de Map.

### Cómo acceden a los miembros de la clase contenedora?

-   Un objeto de una clase anidada tiene implícitamente una referencia al objeto de la clase que lo instanció (clase contenedora). Es a través de ésta referencia oculta que tiene acceso al estado completo del objeto contenedor, incluyendo sus datos privados.
-   El compilador es quien agrega esta ref. implícita en el constructor de la clase anidada.
-   Siempre un objeto de una clase anidada está asociado con un objeto de la clase contenedora: la construcción de un objeto de la clase anidada **requiere** de la referencia al objeto de la clase contenedora.

### Como nombrar al objeto de la clase contenedora?

-   Si el nombre de la variable/método de la clase contenedora no está repetido en nuestra clase anidada, podemos acceder directamente.
-   En caso contrario, podemos acceder vía NombreClaseContedora.this.variableOMetodo.

### Objetos función

-   Java no soporta funciones (métodos que no están dentro de ninguna clase) ni referencias a funciones.
-   Un objeto-función es una **instancia de una clase que exporta métodos que realizan operaciones sobre otros objetos que se pasan como parámetros**.
-   Usar clases anónimas en algunas circunstancias creará un objeto nuevo cada vez, por ejemplo si se ejecuta repetitivamente. Una solución más eficiente consiste en **guardar la referencia al objeto función en una constante de clase y reusarla cada vez que se necesita**.
-   Los objetos-función permiten implementar el patrón Strategy. Este patrón se implementa declarando una interface que representa la estrategia y estrategias concretas (diferentes clases) que implementan dicha interface.
    -   Si la estrategia concreta se usa sólo una vez, entonces se declara e instancia como una clase anónima.
    -   Si una estrategia concreta se usa repetitivamente es conveniente definirla como una clase interna privada y exportar la estrategia mediante una constante pública de clase del tipo de la interface.
    -   De esta manera es posible intercambiar en ejecución las estrategias.

## Clases internas

### Introducción

-   Son como las clases anidadas solo que además son `static`.
-   Tienen acceso a todos los miembros declarados `static` de la clase que las contiene, incluso si son `private`.
-   Un objeto de una clase interna **no** tiene implícitamente una referencia al objeto de la clase que lo instanció (clase contenedora). Es por esto que no tienen acceso a las variables y métodos de instancia de su clase contenedora.

### Patrón builder

-   El Builder es un patrón que permite crear/construir/instanciar objetos complejos de a poco, paso por paso.
-   Se puede implementar este patrón creando una clase interna estática Builder dentro de nuestra clase contenedora.

## Clases locales

### Introducción

-   Son clases definidas dentro de un método o de un bloque de código.
-   No usan especificador de acceso (no pueden declararse `public`, `protected`, `private` ni `static`) dado que su alcance está completamente restringido al bloque de código donde están definidas, es decir, **solo son visibles dentro de ese bloque de código**.
-   Las interfaces y enums **no pueden definirse localmente**.
-   Las instancias de clases locales pueden acceder a todos los miembros de la clase contenedora, al igual que ocurría con las clases anidadas.

## Clases anónimas

### Introducción

-   Son clases locales pero sin nombre.
-   Se crean extendiendo una clase o implementando una interface.
-   Combinan la sintaxis de definición de clase con la de instanciación, es decir, son simultáneamente declaradas e instanciadas en el punto donde se van a usar.
-   Solo tienen acceso a las variables locales del bloque de código donde fueron declaradas.
-   Las variables locales, parámetros de métodos y parámetros de manejadores de excepciones que se usan en las clases locales y anónimas son [efectivamente final](https://medium.com/@itsandip1/understanding-javas-effectively-final-variables-61e03a0be93a).
-   No se les puede definir un constructor ya que esto requiere que la clase tenga nombre, en su lugar se usan **bloques de inicialización**. Solo se puede definir un bloque de este tipo.
-   Solo pueden **extender una clase** o **implementar una sola interface**. No pueden hacer ambas.
-   Las interfaces y enums **no pueden definirse anónimamente**.

```java
public Datos info(int x) {
    return new Datos(x) {
        public int valor() {
            return super.valor() * 50;
        }
    };
}

// Es equivalente a:

public Datos info(int x) {
    class MisDatos extends Datos {
        public MisDatos(int y) {
            super(y);
        }
        public int valor() {
            return super.valor() * 50;
        }
    }
    return new MisDatos(x);
}
```

### Lambdas

-   A partir de JAVA 8 las interfaces con un único método que no requieren del estado de un objeto son **especiales** y merecen un tratamiento especial.
-   Estas interfaces se conocen como **interfaces funcionales**, que pueden **ser implementadas por lambdas**.
-   Los lambdas son similares a las clases anónimas en cuanto a su función, pero mucho más concisas.

```java
Collections.sort(arreglo,
 (s1, s2) -> Integer.compare(s1.length(), s2.length()));
```

---

<h1 align="center">Clase 4 - 18 de septiembre, 2024</h1>

## Tipos enumerativos

### Introducción

-   Los tipos enumerativos se introdujeron por primera vez en Java en la versión 5.0.
-   Son un **tipo especial de clases**, un **tipo de datos que tiene asociado un conjunto de valores finito y acotado**.
-   Declaración:

```java
package labo;

public enum Estados { CONECTANDO, LEYENDO, LISTO, ERROR;}

// Se referencian sus valores con: Estados.CONECTANDO Estados.LEYENDO Estados.LISTO Estados.ERROR
```

-   Sus valores:
    -   Son instancias del enum.
    -   Son llamados "valores enumerados" o "constantes enum".
    -   Por convención, se escriben en MAYÚSCULAS.
    -   Son implícitamente `public static final`.
-   A un enum se le pueden asignar solo uno de sus valores definidos en su estructura interna, o null. Nada más.
-   Los enums proveen seguridad de tipos: el compilador puede chequear si a un método se le pasa un objeto de tipo enum.

### Implementación en Java

-   Cuando se crea un enum, el compilador crea una clase que extiende de java.lang.Enum. No se puede extender la clase Enum para crear un enum propio.
-   Los enums **no tienen constructores públicos**. Sus unicas instancias son las que se declaran internamente.
-   Los enums pueden implementar interfaces. Por defecto, implementan las interfaces Comparable y Serializable.
-   No pueden extenderse.

### Métodos

-   `final int compareTo()`: establece un orden entre los valores enumerados de acuerdo al **orden en que aparecen en la declaración**.
-   `final boolean equals(Object other)`: es seguro comparar valores enumerativos usando el operador == en lugar del método equals() dado que el conjunto de valores posible es limitado. El método equals() internamente usa el operador ==.
-   `final String name()`: devuelve el nombre de la constante enum.
-   `final int ordinal()`: devuelve la posición del enum según está declarado.
-   `String toString()`: devuelve el nombre de la instancia del enum.
-   `static values()`: devuelve en un arreglo todos los valores del enum en el orden en que fueron declarados.
-   Constructores internos: los objetos del enum pueden tener datos dentro, los cuales se declaran, y se inicializan en un constructor interno.
-   Los enums pueden también tener métodos que retornan los valores de los atributos de los objetos del enum.

### EnumMap y EnumSet

-   La clase java.util.EnumMap es una implementación específica de Map que requiere como key un enum. Su utilidad es que nos permite acotar el conjunto de keys que el Map tendrá.
-   La clase java.util.EnumSet es una implementación específica de Set adaptada a valores de tipo enum.

### Comportamiento propio de cada constante enumerativa

-   Es posible asociar comportamiento diferente con cada constante enumerativa asociando un método "{ ... }" al momento de declarar la instancia del enum.

## Genéricos

### Introducción

-   En Java se pueden definir y usar tipos y métodos genéricos (no se puede en tipos enumerativos, clases anónimas, ni subclases de excepciones).
-   Un tipo genérico contiene uno o más tipos de datos como parámetro formal.
-   `public class Clase<E>`
    -   Clase es un tipo genérico.
    -   E es un parámetro formal que denota un tipo de dato.
    -   Los elementos que manipulará Clase serán del tipo desconocido E.
-   Una clase genérica debe tener el mismo comportamiento para todos sus tipos posibles de parámetros.
-   Los tipos parametrizados se forman a partir de los tipos genéricos al asignarle tipos reales a los parámetros formales:
    -   `public class Clase<E>`
    -   `Clase<String> clase;`
    -   `Clase<Integer> clase;`

### Motivación

-   Los genéricos ofrecen una mejora para el sistema de tipos:
    1. Permite operar sobre objetos de múltiples tipos.
    2. Provee seguridad, permitiendo detectar errores en tiempo de compilación: la inserción errónea genera un mensaje de error que explica exactamente lo que está mal.
    3. Los programas que usan genéricos son reusables y promueven clean code.
-   Si no usamos genéricos es muy común tener errores en tiempo de ejecución, relacionados al casteo, que no pueden ser detectados por el compilador de antemano.

### Tipos parametrizados con comodines

-   El tipo genérico `<?>` se usa para denotar a la familia de todos los tipos, o un conjunto de algún tipo desconocido.
-   Básicamente, nos permite pasar un argumento de cualquier tipo al método.
-   No se puede usar en la definición de clases ni al hacer `new`.
-   Permiten una mayor flexibilidad.
-   El argumento de este tipo desconocido que se pasa por parámetro no puede ser modificado, es de solo lectura. Se trata como una instancia de Object.
-   El tipo genérico `<? extends T>` simboliza "cualquier tipo desconocido que es una subclase o subtipo de T, incluyendo a T".
    -   Por ejemplo: `List<? extends Number> lista` familia de todos los tipos de listas cuyos elementos son subtipos de Number.
-   El tipo genérico `<? super T>` simboliza "cualquier tipo desconocido que es una superclase o supertipo de T, incluyendo a T".
    -   Por ejemplo: `Comparable<? super String> s` familia de todas las instanciaciones de la interface Comparable para tipos que son supertipos de String.
-   Estos dos se usan cuando se necesita saber parcialmente el tipo de argumentos que se pasarán al método, pero no totalmente.

### Interoperabilidad con legacy code

-   En Java los genéricos se implementan mediante la técnica llamada "erasure" (borrado): el compilador usa la información de los tipos genéricos y tipos parametrizados para compilar y luego elimina la información del tipo.
-   `List<Integer>` y `List<String>` son traducidas a `List`. El bytecode es el mismo que el de `List`.
-   Después de la traducción por borrado desaparece toda la información del tipo.
-   Es posible invocar a un método diseñado con tipos parametrizados con tipos sin parametrizar y viceversa.

---

<h1 align="center">Clase 5 - 2 de octubre, 2024</h1>

## Excepciones

### Introducción

-   Una excepción es un **evento** o **problema** que ocurre durante la ejecución de un programa e **interrumpe el flujo normal de ejecución de instrucciones** debido a que no cuenta con la información necesaria para resolver el problema en el contexto en que sucedió. Lo único que se puede hacer es abandonar dicho contexto y pasar el problema a un contexto de más alto nivel.
-   Java usa excepciones para proveer manejo de errores a sus programas. Por ejemplo:
    -   Acceso a posiciones inválidas de un arreglo
    -   Falta de memoria en el sistema
    -   Intentar abrir un archivo que no existe en el file system
    -   Ejecutar una query sobre una tabla inexistente de una base de datos
    -   Hacer un casting a un tipo de dato inapropiado
-   Las excepciones solo ocurren dentro de métodos y se llevan a cabo los siguientes pasos:
    1. Se crea un **objeto excepción** en la heap con el operador new, como cualquier otro objeto Java
    2. Se lanza la excepción, es decir se interrumpe la ejecución del método y el objeto excepción es expulsado del contexto actual. En este punto comienza a funcionar el mecanismo de manejo de errores que consiste en buscar un lugar apropiado donde continuar la ejecución del programa. Este lugar apropiado es el manejador de excepciones, cuya función es recuperar el problema.

### Tipos de excepciones en Java

-   En Java las excepciones se clasifican en 3 tipos:

1. **Checked Exception o Verificables en Compilación**: representan un problema que puede ser recuperado.
    - Las aplicaciones bien escritas pueden anticipar y recuperar este tipo de errores.
    - El compilador verifica que estos errores estén contemplados.
    - Java obliga a los métodos que disparan este tipo de excepciones a que capturen y manejen el error o lo propaguen.
2. **Runtime Exception o No Verificables en Compilación**: representan errores internos de la aplicación que no se pueden anticipar ni recuperar.
    - En general son bugs del programa y son causados por errores de lógica o mal uso de la API de Java.
    - Ejemplos:
        - División por cero.
        - Referencias nulas.
        - Index out of bounds.
        - Errores de casting.
3. **Error**: representan errores externos a la aplicación relacionados al hardware y/o a la falta de memoria RAM. No son anticipables ni recuperables.

### Manejador de excepciones

-   Cuando un método dispara una excepción, crea un objeto Throwable (clase raíz de todas las excepciones) en la heap, retorna ese objeto y comienza a funcionar el mecanismo de manejo de errores. Java busca un manejador de excepciones adecuado para dicho error en la pila de ejecución de métodos.
-   Un manejador de excepción es **adecuado si el tipo de la excepción disparada coincide con el de la manejada**.
-   Si el sistema de ejecución no encuentra un manejador apropiado en la pila de ejecución, la excepción será atendida por un manejador default que finaliza la ejecución del programa.

#### Estructura sintáctica

-   Bloque `try`:
    -   Las sentencias que pueden disparar excepciones van dentro de este bloque.

```java
try {

}
```

-   Bloque `catch`:
    -   Son los manejadores de excepciones.
    -   Puede haber **varios** para un mismo `try`.
    -   Se colocan inmediatamente después de que termina el bloque `try`.
    -   Si se dispara una excepción dentro del bloque try, el mecanismo de manejo de excepciones comienza a buscar el **primer manejador de excepciones con un argumento que coincida con el tipo de excepción disparada**. La coincidencia entre el tipo de la excepción disparada y la de su manejador puede no ser exacta. **El tipo de las excepciones del manejador puede ser cualquier superclase de la excepción disparada**.
    -   Luego se ejecuta el bloque `catch` y la excepción se considera manejada/recuperada. Solamente se ejecuta el bloque `catch` que coincide con la excepción disparada. Luego continúa la ejecución normal.
    -   Si adentro del bloque `try` la invocación a diferentes métodos dispara el mismo tipo de excepción, solo necesitamos un único manejador de excepciones.

```java
try {

}
catch {

}
```

```java
class B extends Exception {}
class A extends B {}

try {
    throw new A();
}
catch (A a) {
    // Podríamos eliminar el primer catch y dejar solamente el segundo ya que A extiende de B.
}
catch (B b) {

}
```

-   Bloque `finally`:
    -   Tiene el propósito de liberar recursos antes que el control sea pasado a otra parte del programa, independientemente de si se disparó o no una excepción.
    -   Las sentencias dentro de este bloque siempre se ejecutan independientemente de lo que sucedió en el `try`.
    -   Debe ir luego de un `try`, pero ese `try` no necesariamente debe tener un `catch`.

```java
finally {

}
```

### Jerarquía de clases de excepciones

![Jerarquía de clases de excepciones](https://dotnettrickscloud.blob.core.windows.net/notes/3520240404132014.png)

-   Solamente instancias de Throwable o de alguna de sus subclases pueden ser disparados por la JVM o por la sentencia `throw`. A su vez el tipo del argumento de la cláusula `catch` solamente puede ser Throwable o de alguna de sus subclases.
-   Métodos útiles de la clase Throwable:
    -   `String getMessage()`: devuelve un mensaje detallado de la excepción.
    -   `String getLocalizedMessage()`: idem anterior, pero adaptado a la región.
    -   `String toString()`: devuelve una descripción corta del Throwable incluyendo el mensaje (si existe).
    -   `void printStackTrace()`
    -   Imprime el error y el stack-trace del objeto. El stack-trace muestra la secuencia de métodos invocados que condujo al punto donde se disparó la excepción.

### Especificación de excepciones

-   La especificación de excepciones es parte de la interfaz pública del método y se ubica luego de la lista de argumentos. Se usa la palabra clave `throws` seguida por una lista de tipos de excepciones que pueden dispararse en el alcance de dicho método.
-   Si un método no captura ni maneja las excepciones checked disparadas dentro de su alcance, el compilador JAVA **fuerza al método a especificarlas en su declaración, propagarlas**.
-   En algunas situaciones es mejor que un método propague las excepciones, por ejemplo si se está implementando una librería, es posible que no se puedan prever las necesidades de todos los usuarios de la librería. En este caso es mejor no capturar las excepciones y permitirle a los métodos que usan las clases que manejen las excepciones que podrían dispararse.

### Disparar excepciones

-   Se puede disparar excepciones con la palabra clave `throw` seguido de `new` Excepcion, con Excepcion un Throwable.
-   Se puede re-disparar excepciones:

```java
try {

}
catch (FileNotFoundException e) {
    throw e;
}
catch (IOException e) {

}
```

### Restricciones en excepciones

-   Cuando se sobreescribe un método solamente se pueden disparar las excepciones **especificadas en la versión de la clase base del método**. La utilidad de esta restricción es que el código que funciona correctamente para un objeto de la clase base, seguirá funcionando para un objeto de la clase derivada.
-   La interface de especificación de excepciones de un método puede **reducirse y sobreescribirse en la herencia, pero nunca ampliarse**. Es exactamente opuesto a lo que ocurre en la herencia con los especificadores de acceso de una clase.
-   Los constructores no se sobreescriben.
-   Los constructores de una subclase pueden disparar excepciones diferentes a las excepciones disparadas por el constructor de la superclase.
-   Hay que ser cuidadoso de dejar el objeto que se intenta construir y no se puede, en un estado seguro.

---

<h1 align="center">Clase 6 - 9 de octubre, 2024</h1>

## Expresiones Lambda

### Introducción

-   La idea de las expresiones lambda en Java se origina gracias al concepto de interfaces funcionales, que fue agregado en Java 8.
-   Las interfaces funcionales son interfaces que poseen un único método.
-   Se pueden crear instancias de interfaces funcionales usando lambdas.
-   Una expresión lambda es una **función que puede o no tomar parámetros de entrada y devuelve un valor**. Posee las siguientes características principales:
    -   No tiene nombre.
    -   No pertenece a ninguna clase
    -   Se puede pasar como parámetro.
    -   Se puede ejecutar on-demand.
    -   Deberían ser cortas, 3 líneas como máximo.
    -   Son similares a las clases anónimas pero mucho más concisas.
    -   Se pueden escribir de muchas formas.

### Inferencia de tipos

-   Si usamos tipos genéricos, en los lambdas no se escriben los tipos de datos, ya que el compilador los infiere del contexto.

```java
List<String> palabras = new ArrayList<>();
palabras.add("hola");
palabras.add("chau");
Collections.sort(palabras, (p1, p2) -> Integer.compare(p1.length(), p2.length()));

// Si no usamos tipos genéricos se vuelve mucho más verboso e inseguro:
List palabras = new ArrayList<>();
palabras.add("hola");
palabras.add("chau");
Collections.sort(palabras, (String p1, String p2) -> Integer.compare(((String)p1).length(), ((String)p2.length())));
```

### Formas de escribir lambdas

-   Si el lambda es de una línea, se puede omitir la palabra clave `return`.

1. Parámetros sin usar paréntesis ni especificando tipos

```java
parámetro -> System.out.println("Hola " + parámetro)
```

2. Parámetros usando paréntesis pero no especificando tipos

```java
(parámetro) -> System.out.println("Hola " + parámetro)
```

3. Parámetros usando paréntesis especificando tipos

```java
(String parámetro) -> System.out.println("Hola " + parámetro)
```

4. Bloque de código entre llaves y con sentencia `return`

```java
(String parámetro) -> {
    return "Hola " + parámetro
}
```

### Referencias a métodos (operador ::\)

-   Cuando lo único que hace la expresión lambda es invocar a un método con los parámetros que recibió, se pueden usar **referencias a métodos** para obtener un código más conciso.

```java
list.forEach(item -> System.out.println(item));

// Se puede simplificar a (son equivalentes):

list.forEach(System.out::println);
```

## Colecciones

### Introducción

-   Una **colección** es un objeto que agrupa múltiples elementos y que se usa para almacenar, recuperar, manipular y comunicar datos agregados. Representan elementos que naturalmente/intuitivamente se agrupan, como podría ser una carpeta de emails.
-   Un **framework de colecciones** es una arquitectura que permite representar y manipular colecciones de datos de manera estándar. Se compone de:
    -   Interfaces: tipos de datos abstractos que representan colecciones. Permiten que las colecciones sean manipuladas **independientemente de los detalles de implementación**. Forman una jerarquía.
    -   Implementaciones: son las implementaciones concretas de las interfaces. Son estructuras de datos reusables.
    -   Algoritmos: son métodos que realizan operaciones útiles (búsquedas y ordenamientos) sobre objetos que implementan alguna de las interfaces de colecciones. Son métodos polimórficos: el mismo método se usa sobre diferentes implementaciones de las interfaces de colecciones. Son unidades funcionales reusables.
-   El framework de colecciones de JAVA está formado por un conjunto de clases e interfaces ubicadas mayoritariamente en el paquete java.util.
-   A partir de JAVA 5 soporta tipos genéricos. El compilador inserta castings automáticamente y realiza comprobación de tipos cuando se agregan elementos, evitando errores que sólo podían detectarse en ejecución. Como resultado los programas son más seguros y claros.

### Ventajas

-   **Reduce la programación**: provee estructuras de datos y algoritmos útiles. Facilita la interoperabilidad entre APIs no relacionadas evitando escribir adaptadores o código de conversión para conectar APIs.
-   **Provee estructuras de datos de tamaño ilimitado**: es posible almacenar la cantidad de objetos que se desee.
-   **Aumenta la velocidad y calidad de los programas**: provee implementaciones de estructuras de datos y algoritmos de alta performance y calidad. Las diferentes implementaciones de las interfaces son intercambiables pudiendo los programas adaptarse a diferentes implementaciones.
-   **Permite interoperabilidad entre APIs no relacionadas**: establece un lenguaje común para pasar colecciones de elementos.
-   **Promueve la reusabilidad de software**: las interfaces del framework de colecciones y los algoritmos que manipulan las implementaciones de las interfaces son reusables.

### Motivación para la creación de tipos genéricos

-   Los tipos genéricos en JAVA fueron incorporados fundamentalmente para implementar colecciones genéricas.
-   El framework de colecciones no-genérico en JAVA no ofrecía ninguna forma de manipular colecciones **homogéneas**. Todas las colecciones contenían elementos de tipo Object y por esa razón eran de naturaleza **heterogénea**, mezcla de objetos de diferente tipo.
    -   Esto se puede observar desde la API de colecciones (JSE 4): las colecciones no-genéricas aceptan objetos de cualquier tipo y retornan una referencia a un Object cuando un elemento es retornado.
-   El framework de colecciones genérico de JAVA permite implementar colecciones **homogéneas**. Este framework se define a través de interfaces y clases genéricas que pueden ser instanciadas por muchos tipos.
    -   Por ejemplo, la interface genérica `List<E>` puede ser parametrizada como una `List<String>`, `List<Integer>`, cada una de ellas es una lista homogénea de valores strings, enteros, etc. A partir de la clase genérica `ArrayList<E>` puede obtenerse la clase parametrizada `ArrayList<String>`, `ArrayList<Double>`, etc.

### Estructura de la jerarquía de colecciones de Java

![Estructura de la jerarquía de colecciones de Java](https://i.imgur.com/QKCARY1.png)

-   Las interfaces **centrales** especifican los múltiples contenedores de elementos.
    -   Permiten a las colecciones ser manipuladas independientemente de los detalles de implementación.
-   Las interfaces **secundarias** especifican las formas de recorrer las colecciones.
-   Todas las interfaces de colecciones son genéricas, encapsulan distintos tipos de colecciones de objetos y son el fundamento del framework de colecciones de Java; pertenecen al paquete java.util.

### Interface Collection

-   Es la raíz de la jerarquía de colecciones.
-   Es genérica: cuando se declara un objeto Collection es posible establecer el tipo de dato que se almacenará en la colección y de esta manera se evita la necesidad de castear cuando se leen los elementos. Se evitan errores de casting en ejecución y se le da al compilador información sobre el tipo usado para poder hacer un chequeo fuerte de tipos.
-   Generaliza el concepto de grupos de objetos llamados elementos.
-   No posee una implementación directa.

#### Interface List

-   Secuencia de elementos, cada uno con su posición.
-   Almacena los elementos en el mismo orden en que fueron insertados.
-   Permite elementos duplicados.
-   Provee acceso indexado.
-   Define métodos para recuperar y agregar elementos en una posición determinada o índice.
-   Es una implementación de List basada en arreglos de longitud variable, es similar a Vector. Las operaciones `size()`, `isEmpty()`, `get()`, `set()`, `iterator()`, y `listIterator()` tienen tiempo de ejecución constante O(1). La operación `add()` tiene tiempo de ejecución lineal O(n).

#### Interface Set

-   Colección de objetos sin duplicados y sin orden (a priori).
-   Modela el concepto de conjunto matemático (teoría de conjuntos).
-   Es usado para representar conjuntos de cosas que no se repiten, por ej. las materias que cursa un estudiante, o los procesos en una computadora.
-   Es una implementación de Set basada en una tabla de hashing. No hay garantías acerca del orden de ejecución en las distintas iteraciones sobre el conjunto. Las operaciones básicas `(add()`, `remove()`, `size()`, `contains()`) tienen tiempo de ejecución constante O(1).

##### Interface SortedSet

-   Es un Set que mantiene todos los elementos ordenados en orden ascendente.
-   Se agregan métodos adicionales para sacar ventaja del orden.
-   Se usan para conjuntos ordenados naturalmente.

##### Interface NavigableSet

#### Interface Queue

-   Es una colección diseñada para mantener elementos que esperan por procesamiento.
-   Mantiene los elementos previamente a ser procesados.
-   Además de las operaciones de Collection, agrega operaciones adicionales para inserción, extracción e inspección de elementos.
-   No permite elementos nulos.
-   Típicamente los elementos de una Queue están ordenados mediante una estrategia **FIFO**.
-   Existen implementaciones de colas de prioridades.
-   Hay dos implementaciones de Queue: PriorityQueue y LinkedList (también implementa List)

##### Interface Dequeue

-   Puede ser usada con estrategia **FIFO** y como una **LIFO**.
-   Todos los elementos pueden ser insertados, recuperados y removidos de ambos extremos.

#### Interface Map

-   Representa asociaciones entre objetos de la forma **clave-valor**.
-   No hereda de Collection.
-   No permite claves duplicadas.
-   Cada clave está asociada a lo sumo con un valor.
-   Tanto la clave como el valor son tipos genéricos.
-   También llamada diccionario.
-   Tiene similitudes con HashTable.
-
-   **HashMap**: es una implementación de un Map basada en una tabla de hashing. Las operaciones básicas (get() y put()) tienen tiempo de ejecución constante O(1).

##### Interface SortedMap

-   Es un Map que mantiene sus asociaciones ordenadas **ascendentemente por clave**.
-   Son usados para colecciones de pares clave-valor **naturalmente ordenados** (diccionarios, directorios telefónicos).

##### Interface NavigableMap

### Recorrer una colección

1. **Usando el for-each**:

    - Forma concisa de recorrer colecciones y arreglos.
    - Se incorporó en JSE 5.
    - Es la manera más legible y preferida.
    - Funciona con cualquier cosa que produzca un iterador. La interface Collection extiende de Iterable, entonces cualquier implementación de Set, List y Queue pueden usar el for-each.

2. **Usando la interface Iterator**:
    - Un objeto Iterator permite recorrer una colección de forma secuencial, y remover elementos selectivamente si se desea. Se obtiene el iterador de una colección invocando al método `iterator()`. Una colección es un objeto Iterable.
    - No se recomienda usar por ser menos legible y más engorroso.

### ¿Cómo las interfaces Sorted mantienen el orden de sus elementos?

-   De acuerdo al ordenamiento natural de sus elementos (en el caso de SortedMap, de sus claves) o a un comparador de ordenación provisto en el momento de la creación (**Comparator**).
-   Las interfaces Comparable y Comparator permiten comparar objetos y de esta manera es posible ordenarlos.
-   Múltiples clases de la plataforma Java implementan la interface Comparable, entre ellas: String, Integer, Double, Float, Boolean, Long, Byte, Character, Short, Date, etc.

---

<h1 align="center">Clase 7 - 16 de octubre, 2024</h1>

## Anotaciones

### Introducción

-   Son un tipo de dato, un tipo especial de interface que se usa para anotar declaraciones.
-   Una anotación es una instancia de un tipo anotación.
-   Se expresa con el prefijo "@".
-   Son metadatos del código fuente que proveen información extra que es testeada y verificada en compilación.
-   Se pueden aplicar a paquetes, clases, interfaces, enums, variables, parámetros, métodos, constructores, etc.
-   Se pueden leer desde el código fuente, desde archivos .class, y usando **reflection**.
-   El código anotado no es afectado. Las anotaciones solo proveen info para otros sistemas.
-   El desarrollo basado en anotaciones alienta al estilo de programación declarativa, donde el programador dice qué debe hacerse y las herramientas lo hacen automáticamente.

### @Override

-   Declaramos que se **sobreescribe** el método definido en la superclase.
-   El compilador examina la superclase y garantiza que el método que posee la anotación @Override en la subclase esté definido en la superclase.
-   Nos ayuda a evitar errores.
-   Los IDEs pueden generar alertas si un método sobreescribe un método de la superclase y no posee la anotación @Override.

### @Deprecated

-   Se usa para declarar que el elemento marcado está desaprobado y se dejará de usar/será reemplazado por otro en futuras versiones.
-   El compilador alerta o emite un error cuando un elemento anotado como @Deprecated es accedido por código que está en uso.
-   Puede aplicarse a métodos, clases, propiedades.
-   El objetivo es desalentar el uso del elemento marcado como @Deprecated.

### @SuppressWarnings

-   Es útil para eliminar advertencias del compilador a ciertas partes del programa.
-   Las alertas que pueden suprimirse varían, pero las más comunes son "deprecation", "unchecked", "unused".

### @FunctionalInterface

-   Asegura que la interface funcional define un único método.
-   Si posee más de un método, el compilador emite un mensaje de error: **Invalid @FunctionalInterface annotation"**.
-   Es una indicación explícita para los programadores y herramientas de desarrollo que la interface está diseñada para ser usada como funcional.

### Anotaciones personalizadas

-   Es similar a declarar una interface: el símbolo "@" precede a la palabra clave interface.
-   El cuerpo de las anotaciones contiene declaraciones de elementos o parámetros que permiten especificar valores para las anotaciones.
-   Si una anotación posee un solo elemento se puede usar el nombre **value** y de esta manera, cuando anotamos un elemento, omitimos el nombre del elemento seguido del signo "=".

### Anotaciones Marker

-   Son anotaciones sin elementos.
-   Son útiles para marcar elementos de una aplicación con un determinado propósito.

### ¿Para qué usar anotaciones?

-   Las anotaciones no poseen lógica ni afectan el código que anotan.
-   Son usadas por **procesadores o consumidores o parsers de anotaciones**, que son aplicaciones o sistemas que hacen uso del código anotado y ejecutan diferentes acciones dependiendo de la información suministrada.
    -   Por ejemplo: JUnit lee y analiza las clases de testeo anotadas y decide por ejemplo en qué orden serán ejecutadas las unidades de testeo. Hibernate usa anotaciones para mapear objetos a tablas de la BD.
-   Las anotaciones pueden ser procesadas en compilación o en ejecución usando **reflection**.
-   Las anotaciones son compiladas a .class y recuperadas en ejecución.
-   Los procesadores mencionados usan **reflection** para leer y analizar el código anotado en ejecución.

### Elementos de las anotaciones

-   Los tipos permitidos para los elementos de una anotación son:
    -   Primitivos.
    -   String
    -   Class
    -   Enums
    -   Anotaciones
    -   Arreglos de cualquiera de los tipos mencionados
-   Ningún elemento puede no especificar valores, los elementos tienen valores default o provistos.
-   Ninguno de los elementos puede tomar valor null.

### Generación de archivos externos

-   Las anotaciones son especialmente útiles cuando trabajamos con frameworks Java que requieren de cierta información adicional que acompaña al código.
-   Tecnologías como web services, librerías de custom tags y herramientas ORM como Hibernate requieren de archivos descriptores XML que son externos al código. Trabajar con un archivo descriptor separado requiere mantener 2 fuentes de información separadas sobre una clase y es frecuente que aparezcan problemas de sincronización entre ambas. El programador, además de saber Java, debe saber cómo manipular el archivo descriptor.
-   Por ejemplo: proveer un soporte básico de mapeo objeto-relacional para automatizar la creación de una tabla de la BD y guardarla en una clase Java. Usando anotaciones podemos mantener toda la info en el .java → necesitamos anotaciones para definir el nombre de la tabla asociada con la clase, las columnas y los tipos SQL que mapean con las propiedades de la clase.

## Reflexión

### Introducción

-   Es la capacidad de inspeccionar, analizar y modificar código en ejecución.
-   El paquete java.lang.reflect ofrece acceso programático a información de las clases **cargadas en ejecución**.
-   El punto entrada de reflection es el objeto Class: contiene métodos para recuperar información de constructores, métodos, variables, etc. Es posible crear instancias, invocar métodos, acceder a variables de instancia.

### Meta-anotaciones

-   La declaración de anotaciones requiere de meta-anotaciones que indican **cómo será usada la anotación**.
-   Java provee 4 meta-anotaciones: @Target, @Retention, @Documented, @Inherited.

---

<h1 align="center">Clase 8 - 23 de octubre, 2024</h1>

## Threads en Kotlin

### Introducción

-   Un thread o hilo es un flujo de control secuencial dentro de un proceso. Se los conoce como "procesos livianos" o "contextos de ejecución".
-   Un thread es similar a un programa secuencial: tiene un comienzo, una secuencia de ejecución, un final y en un instante de tiempo dado hay un único punto de ejecución. Sin embargo, un thread no es un programa. Un thread se **ejecuta adentro de un programa**.
-   Se pueden usar múltiples threads en un mismo programa, ejecutándose simultáneamente.
-   En el modelo de multithreading la CPU asigna a cada thread un tiempo para que se ejecute; cada thread “tiene la percepción” que dispone de la CPU constantemente, sin embargo el tiempo de CPU está dividido entre todos los threads.
-   Un thread se ejecuta dentro del contexto de un programa o proceso y comparte los recursos asignados al programa. A pesar de esto, los threads toman algunos recursos del ambiente de ejecución del programa como propios: tienen su propia pila de ejecución, contador de programa, código y datos.

### Threading en Kotlin

-   Kotlin y Java soportan programas multithreading a través del lenguaje, de librerías y del sistema de ejecución.
-   Hay dos estrategias para usar Threads:
    -   Directamente controlar la creación y el gerenciamiento **instanciando un Thread cada vez que la aplicación requiere iniciar una tarea concurrente**.
    -   Abstraer el gerenciamiento de threads **pasando la tarea concurrente a un ejecutor** para que la administre y ejecute.
-   Tanto Kotlin como Java son multithread: siempre hay un thread ejecutándose junto con las aplicaciones de los usuarios, por ejemplo el garbage collector es un thread que se ejecuta en background; las GUIs dibujan las componentes en la pantalla, etc.

### Función thread()

-   La función `thread()` proporcionada por el paquete `kotlin.concurrent` facilita la creación y ejecución de hilos en un programa: provee el comportamiento genérico de los threads Kotlin: arranque, ejecución, interrupción, asignación de prioridades, etc.
-   Posee la firma:

```kt
fun thread(start: Boolean = true, isDaemon: Boolean = false, contextClassLoader: ClassLoader? = null, block: () -> Unit): Thread
```

-   **start**: Indica si el hilo debe comenzar a ejecutarse inmediatamente después de ser creado o no. Por defecto, es true.
-   **isDaemon**: Indica si el hilo debe ser un hilo daemon. Estos no impiden que la JVM se cierre. Por defecto, es false.
-   **contextClassLoader**: Un ClassLoader que se establece como el cargador de clases del nuevo hilo. Puede ser null si se quiere utilizar el cargador de clases actual.
-   **block**: Es un bloque lambda que contiene el código que se ejecutará en el nuevo hilo.
-   La función devuelve una instancia de Thread que referencia al nuevo hilo creado.

### Métodos de la clase Thread

-   **sleep**: Suspende temporalmente la ejecución del thread que se está ejecutando. Afecta solamente al thread que ejecuta el `sleep()`, no es posible decirle a otro thread que se duerma.
-   **join**: Permite que un thread espere a que otro termine de ejecutarse. El objetivo es esperar por un evento específico: la terminación de un thread. El thread que invoca al `join()` sobre otro thread se bloquea hasta que dicho thread termine. Una vez que el thread se completa, el método `join()` retorna inmediatamente.
-   **yield**: Permite indicar al mecanismo de scheduling que el thread ya hizo suficiente trabajo y que podría cederle tiempo de CPU a otro thread. Su efecto es dependiente del SO sobre el que se ejecuta la JVM.
-   **interrupt**: Es un pedido de interrupción. El thread que lo recibe se interrumpe a sí mismo de una manera conveniente. El pedido causa que los métodos de bloqueo (`sleep()`, `join()`, `wait()`) disparen la excepción InterruptedException y además setea un flag en el thread que indica que al thread se le ha pedido que se interrumpa. Se usa el método `isInterrupted()` para preguntar por este flag.

### Ciclo de vida de un Thread

1. **Estado New Thread**: Inmediatamente después que un thread es creado pasa a estado New Thread, pero aún no ha sido **iniciado**, por lo tanto no puede ejecutarse. Para esto se debe invocar al método start().
2. **Estado Running (Ejecutándose) o Runnable (Ejecutable)**: Después de ejecutarse el método start() el thread pasa al estado Runnable o Ejecutable. Un thread arrancado con start() podría o no comenzar a ejecutarse. No hay nada que evite que el thread se ejecute. La JVM implementa una estrategia (scheduling) que permite compartir la CPU entre todos los threads en estado Runnable.
3. **Estado Not Runnable o Blocked (Bloqueado)**: Un thread pasa a estado Not Runnable o Bloqueado cuando ocurre alguno de estos eventos: se invoca al método `sleep()`, al `wait()`, `join()` ó el thread está bloqueado en espera de una operación de I/O, el thread invoca a un método synchronized sobre un objeto y el lock del objeto no está disponible. Cada entrada al estado Not Runnable tiene una forma de salida correspondiente. Cuando un thread está en estado bloqueado, el scheduler lo saltea y no le da ningún slice de CPU para ejecutarse.
4. **Estado Dead**: Los threads definen su finalización implementando un `run()` que termine naturalmente.

### Prioridades en Threads

-   Cuando se tiene una única CPU, los threads se ejecutarán de a uno a la vez simulando concurrencia. Uno de los gran beneficios de threading es que permite abstraernos de la cantidad física de procesadores que se tiene.
-   Cuando múltiples threads quieren ejecutarse, es el SO el que determina a cuál de ellos le asignará CPU. Los programas Kotlin pueden influir, pero la decisión final es del SO.
-   Se llama scheduling a la estrategia que determina el **orden de ejecución de múltiples threads sobre una única CPU**.
-   La JVM soporta un algoritmo de scheduling simple llamado scheduling de prioridad fija, que consiste en determinar el orden en que se ejecutarán los threads de acuerdo a la prioridad que ellos tienen.
-   Cuando se crea un thread, éste hereda la prioridad del thread que lo creó (NORM_PRIORITY ). Es posible modificar la prioridad de un thread después de su creación usando el método `setPriority(int)`. Las prioridades de los threads son números enteros que varían entre las constantes MIN_PRIORITY y MAX_PRIORITY.
-   El sistema de ejecución elige para ejecutar, entre los threads que están en estado Runnable, **aquel que tiene prioridad más alta**. Cuando éste thread finaliza, cede el procesador, o pasa a estado Bloqueado, comienza a ejecutarse un thread de más baja prioridad.
-   El scheduler usa una **estrategia round-robin** para elegir entre dos threads de igual prioridad que están esperando por la CPU. El thread elegido se ejecuta hasta que un thread de más alta prioridad pase a estado Runnable, ceda la CPU a otro thread, finalice su ejecución ó, expire el tiempo de CPU asignado (time-slicing). Luego, el segundo thread tiene la posibilidad de ejecutarse.
-   El algoritmo de scheduling también es **preemptive**: cada vez que un thread con mayor prioridad que todos los threads que están en estado Runnable pasa a estado Runnable, el sistema de ejecución elige a este nuevo thread de mayor prioridad para ejecutarse.

### Ejecutores

-   Son objetos que encapsulan la creación y administración de threads, permitiendo desacoplar la tarea concurrente del mecanismo de ejecución. Se encargan de crear, usar y schedulear threads.
-   Son una capa intermedia entre el cliente y un thread.
-   Permiten modelar programas como una serie de tareas concurrentes asincrónicas, evitando los detalles asociados con threads: simplemente se crea una tarea que se pasa al ejecutor apropiado para que la ejecute.
-   Es un objeto que implementa la interface Executor.
-   Ejemplo:

```kt
val t = thread() { ... } // Threads creados por el programador

val e = unEjecutor
e.execute { ... }
```

-   El método `execute()` crea y lanza los threads inmediatamente.

### Pool de threads

-   Las implementaciones de ejecutores suelen usar pool de threads, el cual minimiza la sobrecarga causada por la creación de nuevos threads → reuso de threads.
-   Aumenta la performance de aplicaciones que ejecutan muchos threads simultáneamente. El pool adquiere un rol crucial en configuraciones donde se tienen **más threads que CPUs** → programas más rápidos y eficientes.

### Exclusión mutua

-   Con multithreading hay situaciones en que dos o más threads intentan acceder a los mismos recursos al mismo tiempo. Se debe evitar este tipo de colisión sobre los recursos compartidos (durante períodos críticos): acceder a la misma cuenta bancaria en el mismo momento, imprimir en la misma impresora, etc.
-   Para resolver el problema de colisiones, todos los esquemas de multithreading establecen un orden para acceder al recurso compartido. En general se lleva a cabo usando una cláusula que bloquea (lock) el código que accede al recurso compartido y así solamente de a un thread a la vez se accede al recurso. Esta cláusula **implementa exclusión mutua**.
-   Java provee soporte para **exclusión mutua mediante la palabra clave synchronized**.
-   Cada objeto contiene un lock único llamado monitor. Cuando invocamos a un método synchronized, el objeto es “bloqueado” (locked) y ningún otro método synchronized sobre el mismo objeto puede ejecutarse hasta que el primer método termine y libere el lock del objeto.
-   El lock del objeto es único y compartido por todos los métodos y bloques synchronized del mismo objeto. Este lock evita que el recurso común sea modificado por más de un thread a la vez.
-   Es posible definir un **bloque** synchronized:

```java
synchronized (unObjeto) {}
```

-   Un thread puede adquirir el lock de un objeto múltiples veces. Esto ocurre si un método invoca a un segundo método synchronized sobre el mismo objeto, quién a su vez invoca a otro método synchronized sobre el mismo objeto, etc. La JVM mantiene un contador con el número de veces que el objeto fue bloqueado (lock).
    -   Cuando el objeto es desbloqueado, el contador toma el valor cero.
    -   Cada vez que un thread adquiere el lock sobre el mismo objeto, el contador se incrementa en uno.
    -   Cada vez que abandona un método synchronized el contador se decrementa en uno, hasta que el contador llegue a cero, liberando el lock para que lo usen otros threads.
    -   La adquisición del lock múltiples veces sólo es permitida para el thread que lo adquirió en el primer método synchronized que invocó.

### Sincronización

-   `wait()`: Suspende la ejecución del thread y libera el lock del objeto, y así permite que otros métodos synchronized sobre el mismo objeto puedan ejecutarse.
-   `notify()`: Despierta a un thread.
-   `notifyAll()`: Despierta a **todos** los threads esperando por el `wait()`. Cuando eso ocurre, compiten por el lock y que lo obtiene (de forma no determinística) retoma la ejecución.

## Concurrencia en Kotlin

### Corrutinas

-   Un thread es un flujo de control secuencial dentro de un proceso.
-   Una corrutina es un flujo de control secuencial no bloqueante asincrónico dentro de un thread, siendo el cómputo más lightweight dentro de la programación concurrente.
-   Las corrutinas proveen concurrencia pero no paralelismo y pueden suspenderse sin bloquear el thread.
-   Las corrutinas son similares a los threads en la programación concurrente tradicional, pero están basadas en multitareas cooperativas.
-   Los threads son siempre **globales**, mientras que las corrutinas tienen **alcance**.
-   El Scheduling de las corrutinas es **non-preemptive** y es realizado por el lenguaje o el programador. Los cambios entre diferentes contextos de ejecución lo hacen las propias corrutinas en lugar del sistema operativo o la máquina virtual.
-   Las corrutinas se caracterizan por:
    -   Son muy eficientes.
    -   No utilizan context switching.
    -   No reservan espacio extra en la pila de ejecución.
    -   No requieren sincronización.

### Cómo usar corrutinas

-   Las corrutinas forman parte del paquete **kotlinx.coroutines**, por lo que se necesita en el proyecto especificar la siguiente dependencia:

`implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")`

-   Para iniciar una corrutina se debe usar un constructor (principalmente: launch, runBlocking, async) y pasar las sentencias a ejecutar como un bloque de código:

```kt
import kotlinx.coroutines.*

fun main() = runBlocking { //inicia una nueva corrutina y bloquea su hilo contenedor
    launch { // dispara una nueva corrutina y continua.
        delay(1000L) // non-blocking delay de 1 segundo (unidad default ms)
        println("World!") // imprime luego del delay
    }
    println("Hello") // la corrutina principal continúa mientras que la anterior se suspende
}
```

-   El constructor de corrutina launch devuelve un job que es el handle de la corrutina lanzada.
-   El handle de una corrutina puede ser usado para esperar explícitamente la finalización o la cancelación de la misma.
-   El constructor launch puede tomar un parámetro opcional, **CoroutineContext**, que especifica un conjunto de elementos como el dispatcher, el CoroutineName, etc. que determinan el contexto de la corrutina.
-   Otro parámetro opcional del launch es el **CoroutineStart** que define las opciones de arranque:
    -   **DEFAULT**: inicia inmediatamente.
    -   **LAZY**: sólo inicia invocando al `start()`.
    -   **ATOMIC**: ejecuta atómicamente.
    -   **UNDISPATCHED**: ejecuta inmediatamente hasta el primer punto de suspensión en el thread actual.

### Dispatchers y threads

-   El dispatcher de la corrutina que determina qué thread o threads se utilizaran para la ejecución, pudiendo confinar la ejecución a un thread específico, despacharla a un pool de threads o dejar que se ejecute sin confinar.
-   Alternativas para el uso de dispatchers:

    1.  Usar uno de un grupo de varias implementaciones de CoroutineDispatcher:

        -   **Dispatchers.Default**: Usa un pool threads compartidos en background.
        -   **Dispatchers.Main**: Se limita al Main thread y por lo general es single-threaded.
        -   **Dispatchers.IO**: Está diseñado para transferir tareas IO bloqueantes a un grupo compartido de threads.
        -   **Dispatchers.Unconfined**: No se limita a ningún thread específico,permite que la corrutina se reanude en cualquier subproceso utilizado por la función de suspensión correspondiente, sin imponer ninguna política de subprocesos específica.

    2.  Crear un único thread dedicado para ejecutar la corrutina con newSingleThreadContext, pero resultando muy caro desde el punto de vista del uso de recursos.
    3.  Usar java.util.concurrent.Executor arbitrario que pueda convertirse en un dispatcher con la función de extensión asCoroutineDispatcher.

### Modificador suspend

-   Las corrutinas se usan para implementar funciones de suspensión y pueden cambiar contextos solamente en los puntos de suspensión.
-   El modificador **suspend** permite lanzar un método en una corrutina.
-   Los métodos marcados con **suspend sólo pueden ser invocados desde una corrutina o desde otro método suspend**.

### Alcance de corrutinas

-   Utilizando el constructor **coroutineScope** se crea un ámbito de corrutina que no finaliza hasta que todos los hijos lanzados hayan terminado.
-   Para crear corrutinas de nivel superior, alcance de aplicación, se utiliza el constructor **GlobalScope.launch**.
-   Los constructores **runBlocking** y **coroutineScope** difieren principalmente en que el primero bloquea el thread actual, mientras que el segundo sólo suspende; liberando el cómputo para otros usos.

### Constructor async

-   El constructor de corrutina async devuelve un objeto **Deferred<T>**.
-   Es necesario invocar a `await()` para obtener el objeto resultado de tipo T del **Deferred<T>**.
-   Una función común no puede llamar al await, se debe usar launch para lanzar una corrutina nueva desde una función.
-   Se debe usar el async solo cuando se esté dentro de una corrutina o de una función suspend.

### Flujo asincrónico

-   **Flow<T>** representa un flujo de datos asíncrono que emite valores secuencialmente.
-   Usualmente representan cold streams, no se produce ningún valor si no hay nadie que lo colecte.
-   Las principales maneras de construir un flujo son:
    -   `flowOf()` crea un flujo a partir de un conjunto fijo de valores.
    -   `asFlow()` construye un flujo sobre distintos conjuntos de elementos.
    -   `flow {}` fabrica un flujo a partir de llamadas secuenciales a la función emit.

### Canales channel y channelFlow

-   Un canal es conceptualmente muy similar a cola bloqueante con dos operaciones en suspensión **send** y **receive**.
-   channelFlow es utilizado para crear flujos destinados a trabajar de forma concurrente y en lugar de utilizar la función emit utiliza send.

### Canales vs flujos

-   Los canales empiezan a **emitir datos inmediatamente** sin importar si algún consumidor recibe los datos.
-   Los canales se deben **cerrar explícitamente una vez finalizado su objetivo** para evitar pérdidas.
-   Los flujos son una buena opción para el **procesamiento secuencial de datos**.
-   Para delimitar las emisiones al ciclo de vida de un determinado componente se recomienda el uso de los flujos. Si por el contrario la generación de datos no debe estar sujeta a un ciclo de vida específico, se debe usar canales.

---

<h1 align="center">Clase 9 - 13 de noviembre, 2024</h1>

---

## Android

---

<h1 align="center">Clase 10 - 20 de noviembre, 2024</h1>

## ?

---
