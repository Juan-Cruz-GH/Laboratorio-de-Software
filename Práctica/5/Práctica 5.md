<h1 align="center">Práctica 5</h1>

## Temas

-   Arreglos de primitivos y objetos
-   Clases de la API para manejar colecciones de objetos
-   Genéricos
-   Expresiones Lambda

## 1. Se quiere mantener un conjunto de alumnos ordenados por número de legajo, correspondientes a una materia en una Facultad. Defina una clase Alumno en el paquete practica4, que contenga información del alumno, entre otras cosas el legajo, apellido y nombre y DNI.

### a) Defina una clase llamada Materia en el mismo paquete que mantenga información sobre la materia y la nómina de alumnos. Use colecciones genéricas.

Resuelto en IntelliJ, proyecto "5".

### b) Defina en la clase Materia 2 métodos: agregaAlumno(Alumno a) que agregue a alumnos a la nómina de alumnos existentes y getAlumnos() que retorne el conjunto de alumnos inscriptos en la materia.

Resuelto en IntelliJ, proyecto "5".

### c) Pruebe las clases definidas creando agregando al menos 10 alumnos en una Materia. Recorra la colección e imprima sus elementos.

Resuelto en IntelliJ, proyecto "5".

### d) Su colección está ordenada, ¿qué requisito tuvo que cumplir para poder mantenerla ordenada?

Para mantener la colección de alumnos ordenada, lo que hice fue usar el método estático `comparing()` de la clase Comparator cada vez que se agrega un alumno nuevo:

```java
public void agregaAlumno(Alumno a) {
    alumnos.add(a);
    alumnos.sort(Comparator.comparing(Alumno::getLegajo));
}
```

### e) Si quisiera que el criterio de orden se mantenga sobre el apellido y nombre ¿cómo lo haría?

Ordenando por nombre:

```java
public void agregaAlumno(Alumno a) {
    alumnos.add(a);
    alumnos.sort(Comparator.comparing(Alumno::getNombre));
}
```

Ordenando por apellido:

```java
public void agregaAlumno(Alumno a) {
    alumnos.add(a);
    alumnos.sort(Comparator.comparing(Alumno::getApellido));
}
```

### f) Analice una solución que permita mantener una nómina no sólo de alumnos sino también de empleados, clientes, etc. ¿Cómo definiría la colección?

En ese caso definiría una clase abstracta Persona, donde Alumno, Cliente y Empleado son subclases de ella, y luego definiría a la colección:

```java
ArrayList<Persona> personas = new ArrayList<>();
```

En este sentido, se pueden agregar tanto alumnos, como clientes, como empleados a esta colección.

## 2. Considere la siguiente clase:

```java
public class Veterinaria<E> {
    private E animal;

    public void setAnimal(E x) {
        animal = x;
    }

    public E getAnimal() {
        return animal;
    }
}

public class Animal {

}

public class Gato extends Animal {

}

public class Perro extends Animal {

}
```

### a) Indicar cual es el resultado de las siguientes operaciones:

#### i)

```java
Veterinaria<Animal> vet = new Veterinaria<Gato>();
```

❌ No funciona porque no se puede asignar un tipo genérico con un subtipo a un tipo genérico con el supertipo. Es decir, por más que gato sea subclase de Animal, `Veterinaria<Gato>` **no es** subclase de `Veterinaria<Animal>`.

#### ii)

```java
Veterinaria<Gato> vet = new Veterinaria<Animal>();
```

❌ No funciona por la misma razón que el anterior.

#### iii)

```java
Veterinaria<?> vet = new Veterinaria<Gato>();
vet.setAnimal(new Gato());
```

❌ Si bien la primer sentencia es válida, la segunda falla, porque el tipo asignado es desconocido y setAnimal requiere que el tipo sea conocido.

#### iv)

```java
Veterinaria vet = new Veterinaria();
vet.setAnimal(new Perro());
```

✅ Funciona, como no especificamos el tipo, el tipo E será Object por defecto. Esto no es seguro ya que setAnimal ahora puede recibir cualquier objeto, y no solo animales.

#### v)

```java
Veterinaria vet = new Veterinaria<?>();
```

❌ Los comodines (?) no se pueden usar en la sentencia new, es decir, no se pueden usar para crear instancias.

#### vi)

```java
Veterinaria<? extends Animal> vet = new Veterinaria<Gato>();
```

✅ Funciona, vet puede ser de cualquier tipo que extienda de Animal, y como Gato extiende de Animal, es válido.

## 3. Se desea recuperar colecciones de palabras similares y para ello se debe implementar un motor de comparación basado en una técnica particular de string matching:

Esta técnica define una función de similitud entre dos cadenas que indicará cuán similares son dichas cadenas.

Las técnicas utilizadas por estos tipos de motores de comparación están basadas en tokenización (descomposición en unidades básicas), y como resultado del proceso obtendremos un conjunto de tokens, o lo que es lo mismo, de Q-gramas (sub-cadenas de tamaño Q).

La siguiente figura muestra un ejemplo de tokenización en gramas de tamaño 2:

![Ejemplo de tokenización](https://i.imgur.com/rng9GSr.png)

**Explicación**: dada la cadena “Glucosa” se introducen caracteres de inicio y de final de cadena (# y $ símbolos no existentes en el alfabeto utilizado) y se obtiene una lista de Q-gramas mediante el uso de una ventana de tamaño 2 que se desliza a través de los caracteres de la cadena.

Usted debe:

### a) Implementar un diccionario de gramas que almacenará el resultado de la factorización de palabras en Q-gramas, con Q=2, donde las claves del diccionario serán las gramas y el valor almacenado en el mismo serán las listas de palabras que contiene el grama de la clave.

Resuelto en IntelliJ, proyecto "5".

### b) Implementar un motor de comparación basado en la siguiente técnica de string matching:

[Distancia de Levenshtein](http://es.wikipedia.org/wiki/Distancia_de_Levenshtein) menor a tres: Las cadenas comparadas deben poseer una distancia de Levenshtein menor a tres. La distancia de Levenshtein, distancia de edición o distancia entre palabras es el **número mínimo de operaciones requeridas para transformar una cadena de caracteres en otra**.

Por ejemplo, la distancia de Levenshtein entre "casa" y "calle" es de 3 porque se necesitan al menos tres ediciones elementales para cambiar uno en el otro.

El motor de comparación definirá un método que recibirá como parámetro un diccionario de gramas de tamaño 2 y una cadena. Dicho método dividirá la cadena en gramas de tamaño 2, explorará recolectando las palabras almacenadas en el diccionario de gramas que contenga alguno de los gramas de la cadena enviada como parámetro y retornará como resultado la colección de palabras que cumplen con el criterio de comparación.

No lo hice, no entiendo qué piden.

## 4. Implementación de Expresiones Lambda en Java

### a) Defina una clase llamada Facultad que contenga en su interior una lista de alumnos, donde de estos últimos se guarda la siguiente información:

-   nro de alumno
-   nombres
-   apellidos
-   edad
-   materia aprobada
-   nota de aprobación

Sobre la clase Facultad implemente los métodos necesarios utilizando expresiones Lambda a fin de poder realizar las siguientes consultas:

1. Obtener el estudiante con mayor nota.
2. Imprimir dos estudiantes de la lista.
3. El que tomó el curso llamado “Laboratorio de Software”.
4. Obtener los alumnos, cuyo nombre empiece con el carácter "P" y la longitud de su nombre sea menor o igual a 6.

Finalmente implemente una clase TestFacultad que permita probar las consultas anteriores.

Resuelto en IntelliJ, proyecto "5".

### b) Implemente el método ordenarPorNota() en la clase Facultad del ejercicio anterior. Dicho método ordena la lista de estudiantes por nota de aprobación de mayor a menor utilizando una clase interna que implementa la interface java.util.Comparator.

Resuelto en IntelliJ, proyecto "5".

```java
private class Ordenador implements Comparator<Alumno> {
    public int compare(Alumno a1, Alumno a2) {
        return Integer.compare(a2.getNotaAprobacion(), a1.getNotaAprobacion());
    }
}

public ArrayList<Alumno> ordenarPorNota() {
    ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
    Collections.sort(alumnosOrdenados, new Ordenador());
    return alumnosOrdenados;
}
```

1. Modifique el código para reemplazar la clase interna por una expresión lambda.

```java
public ArrayList<Alumno> ordenarPorNota() {
    ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
    Collections.sort(alumnosOrdenados, (a1, a2) -> Integer.compare(a2.getNotaAprobacion(), a1.getNotaAprobacion()));
    return alumnosOrdenados;
}
```

2. Modifique la implementación para que utilice el método estático Comparator.comparingInt(). ¿Qué recibe como parámetro?

```java
public ArrayList<Alumno> ordenarPorNota() {
    ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
    Collections.sort(alumnosOrdenados, Comparator.comparingInt(a -> a.getNotaAprobacion()));
    return alumnosOrdenados;
}
```

3. ¿Es posible utilizar una referencia a método? Utilícela en caso de ser posible.

```java
public ArrayList<Alumno> ordenarPorNota() {
    ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
    Collections.sort(alumnosOrdenados, Comparator.comparingInt(Alumno::getNotaAprobacion));
    return alumnosOrdenados;
}
```
