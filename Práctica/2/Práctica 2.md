<h1 align="center">Práctica 2</h1>

## Temas

-   Interfaces.
-   Polimorfismo.

## 1. Declaración e implementación de interfaces.

### a) ¿Son correctas las siguientes declaraciones?

```java
interface ColPrimarios {
  int ROJO = 1, VERDE = 2, AZUL = 4;
}

interface ColArcoIris extends ColPrimarios {
  int AMARILLO = 3, NARANJA = 5, INDIGO = 6, VIOLETA = 7;
}

interface ColImpresion extends ColPrimarios {
  int AMARILLO = 8, CYAN = 16, MAGENTA = 32;
}

interface TodosLosColores extends ColImpresion, ColArcoIris {
  int FUCSIA = 17, BORDO = ROJO + 90;
}

class MisColores implements ColImpresion, ColArcoIris {
  public MisColores() {
    int unColor = AMARILLO;
  }
}
```

❌ Se produce un error por ambiguedad: cuando TodosLosColores hereda de ColImpresion y ColArcoIris, recibe la constante amarillo de ambos. Una interface no puede tener dos constantes con el mismo tipo y mismo nombre, por lo que no compila.

### b) Analice el código de la interface y las clases que la implementan. Determine si son legales o no. En caso de ser necesario, realice las correcciones que correspondan. ¿Cómo podría modificar el acceso afinar() para evitar realizar cambios en las clases que implementan IntrumentoMusical?

```java
public interface InstrumentoMusical {
  void hacerSonar();
  String queEs();
  void afinar() { };
}

abstract class InstrumentoDeViento implements InstrumentoMusical {
  void hacerSonar() {
    System.out.println("Sonar Vientos");
  }
  public String queEs() {
    return "Instrumento de Viento";
  }
}

class InstrumentoDeCuerda implements InstrumentoMusical {
  void hacerSonar() {
    System.out.println("Sonar Cuerdas");
  }
  public String queEs() {
    return "Instrumento de Cuerda";
  }
}
```

❌ Hay varios errores:

1. El método afinar() en la interface no puede tener implementación a no ser que sea declarado como default, lo cual no es el caso.
2. Los métodos de una interface que no hereda de otras interfaces son siempre public, por ende las clases que implementan estos métodos deben implementarlos de forma public también: hay que agregar public en hacerSonar en ambas clases.

Código corregido:

```java
public interface InstrumentoMusical {
  void hacerSonar();
  String queEs();
  default void afinar() { };
}

abstract class InstrumentoDeViento implements InstrumentoMusical {
  public void hacerSonar() {
    System.out.println("Sonar Vientos");
  }
  public String queEs() {
    return "Instrumento de Viento";
  }
}

class InstrumentoDeCuerda implements InstrumentoMusical {
  public void hacerSonar() {
    System.out.println("Sonar Cuerdas");
  }
  public String queEs() {
    return "Instrumento de Cuerda";
  }
}
```

## 2. Redefina la clase PaintTest del ejercicio 6 de la práctica 1 de manera de imprimir las figuras geométricas ordenadas de acuerdo al valor de su área. Defina la comparación entre figuras geométricas usando la siguiente regla: una figura A es menor una figura B si el área de A es menor que el área de B. Use para ordenar el arreglo de figuras los métodos de ordenación disponibles en la clase java.util.Arrays.

## 3. Se desea implementar un tipo especial de HashSet con la característica de poder consultar la cantidad total de elementos que se agregaron al mismo. Analice y pruebe el siguiente código de manera de corroborar si realiza lo pedido.

```java
public class HashSetAgregados<E> extends HashSet<E> {
  private int cantidadAgregados = 0;
  public HashSetAgregados() {

  }

  public HashSetAgregados(int initCap, float loadFactor) {
    super(initCap, loadFactor);
  }

  @Override
  public boolean add(E e) {
    cantidadAgregados++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    cantidadAgregados += c.size();
    return super.addAll(c);
  }

  public int getCantidadAgregados() {
    return cantidadAgregados;
  }
}
```

✅ El método `add()` parece funcionar bien, ya que al ejecutarlo dos veces con valores distintos, `getCantidadAgregados()` nos devuelve 2.

### a) Agregue a una instancia de HashSetAgregados los elementos de otra colección (mediante el método addAll). Invoque luego al método getCantidadAgregados. ¿La clase tiene el funcionamiento esperado? ¿Por qué? ¿Tiene relación con la herencia?

❌ El método `addAll()` tiene un problema, ya que al pasarle una lista de 3 elementos, `getCantidadAgregados()` nos dice que ahora hay el doble, 6 más en vez de 3.

Esto se debe a que cuando `addAll()` ejecuta el `super.addAll()`, este método de su clase padre internamente luego ejecuta el `add()` de nuestra clase ya que nuestra clase sobreescribió este método, que en nuestro caso vuelve a aumentar cantidadAgregados.

### b) Diseñe e implemente una alternativa para HashSetAgregados. ¿Qué interface usaría? ¿Qué ventajas proporcionaría esta nueva implementación respecto de la original?

Resuelto en el código. Mi solución alternativa sería usar composición en vez de herencia: que HashSetAgregados **tenga** un HashSet internamente, no que herede de HashSet.

### c) Se desea implementar otro tipo especial de Set con la característica de poder consultar la cantidad total de elementos que se removieron del mismo. Diseñe e implemente una solución que permita fácilmente definir nuevos tipos de Set con distintas características.

Resuelto en el código. "Diseñe e implemente una solución que permita fácilmente definir nuevos tipos de Set con distintas características." ???

## 4. Redefina las clases del ejercicio 6 de la práctica 1 de manera que las figuras se puedan serializar.

Resuelto en el código.

### a) ¿Cómo se serializa un objeto? ¿Con qué fin?

En Java, un objeto se serializa implementando la interface **Serializable** (que es una interface de tipo marker, es decir no tiene métodos) y luego utilizando un objeto de la clase ObjectOutputStream.

Los objetos se pueden serializar con el propósito de persistirlos en un archivo en disco o en una base de datos, o enviarlos por red.

### b) ¿Qué relación tiene con el serialVersionUID? Analice su impacto al modificar la implementación de las clases.

El serialVersionUID es un identificador único para cada clase que implementa Serializable que se utiliza en el proceso de de-serialización. Si no lo agregamos explícitamente, Java crea uno implícitamente de forma automática, basado en la estructura de la clase.

Sin embargo, se recomienda declararlo explícitamente para evitar problemas, ya que al modificar la implementación de la clase, Java también cambiará nuestro UID implícito lo cual podría romper compatibilidad con objetos serializados con versiones previas de la clase.
