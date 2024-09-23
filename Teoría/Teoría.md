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

---

<h1 align="center">Clase 5 - 2 de octubre, 2024</h1>

---

<h1 align="center">Clase 6 - 9 de octubre, 2024</h1>

---

<h1 align="center">Clase 7 - 16 de octubre, 2024</h1>

---

<h1 align="center">Clase 8 - 23 de octubre, 2024</h1>

---

<h1 align="center">Clase 9 - 6 de noviembre, 2024</h1>

---
