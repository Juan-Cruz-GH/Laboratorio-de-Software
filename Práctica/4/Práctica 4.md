<h1 align="center">Práctica 4</h1>

## Temas

-   Conceptos y uso de excepciones
-   Try / catch / finally
-   Definición de Excepciones

## 1. Determine si el siguiente código es correcto. Si produce un error, observe de qué tipo es y soluciónelo.

```java
class Excepcion1 extends Exception {}

class Excepcion2 extends Excepcion1 {}

public class Test1 {
    public static void main(String[] args) {
        try {
            throw new Excepcion2();
        } catch(Excepcion1 e1) {
            System.out.println("Se capturó la Excepción1");
        } catch(Excepcion2 e2) {
            System.out.println("Se capturó la Excepción2");
        }
    }
}
```

El código es incorrecto. Se produce un error de "código inalcanzable": como Excepcion2 es subclase de Excepcion1, al hacer `throw new Excepcion2()`, esto **siempre** hará que se ejecute el primer catch y **nunca** el segundo, lo cual el compilador Java prohibe.

Podemos solucionar esto invirtiendo el orden:

```java
class Excepcion1 extends Exception {}

class Excepcion2 extends Excepcion1 {}

public class Test1 {
    public static void main(String[] args) {
        try {
            throw new Excepcion2();
        } catch(Excepcion2 e2) {
            System.out.println("Se capturó la Excepción2");
        } catch(Excepcion1 e1) {
            System.out.println("Se capturó la Excepción1");
        }
    }
}
```

**Resumiendo, siempre debemos capturar excepciones de la más específica a la más general, y no al revés.**

## 2. Ejecute el siguiente código. ¿Cuál es el resultado? Elimine los comentarios y vuelva a ejecutarlo. ¿Cuál es el resultado?

```java
public class Test2 {
    public int unMetodo() {
        // try {
            System.out.println("Va a retornar 1");
            return 1;
        // } finally {
            System.out.println("Va a retornar 2");
            return 2;
        // }
    }
    public static void main(String[] args) {
        Test2 res = new Test2();
        System.out.println(res.unMetodo());
    }
}
```

Al ejecutar el código, se produce una excepción de tipo **_unreachable statement_**, ya que las últimas dos instrucciones de `unMetodo` jamás se ejecutarán, lo cual el compilador de Java prohibe.

Al borrar los comentarios, el resultado es:

```
Va a retornar 1
Va a retornar 2
2
```

Lo que ocurre es que si tanto el bloque `try` como el bloque `finally` tienen sentencias `return`, la del bloque `finally` toma prioridad y sobreescribe la del `try`.

## 3. Ejecute el siguiente código. ¿Cuál es la salida del programa?

```java
public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3");
        try {
            System.out.println("Primer try");
            try {
                throw new Exception();
            } finally {
                System.out.println("Finally del 2º try");
            }
        } catch (Exception e) {
            System.out.println("Se capturó la Excepción ex del 1º Primer try");
        } finally {
            System.out.println("Finally del 1º try");
        }
    }
}
```

Se imprime:

```
Test3
Primer try
Finally del 2º try
Se capturó la Excepción ex del 1º Primer try
Finally del 1º try
```

## 4. Analice el siguiente código y determine si es correcto. Si hay errores, escriba el motivo de cada uno y proponga una solución.

```java
class FutbolException extends Exception {}

class Falta extends FutbolException {}

class EquipoIncompleto extends FutbolException {}

class ClimaException extends Exception {}

class Lluvia extends ClimaException {}

class Mano extends Falta {}

class Partido {
    Partido() throws FutbolException {}
    void evento() throws FutbolException {}
    void jugada() throws EquipoIncompleto, Falta {}
    void penal() {}
}

interface Tormenta {
    void evento() throws Lluvia;
    void diluvio() throws Lluvia;
}

// ------------------------------------------

public class Encuentro extends Partido implements Tormenta {
    Encuentro() throws Lluvia, FutbolException {..}
    Encuentro (String fecha) throws Falta, FutbolException {..}
    void penal() throws Mano {..}
    public void evento() throws Lluvia {..}
    public void diluvio() throws Lluvia {..}
    public void evento() {..}
    void jugada() throws Mano {..}

    public static void main (String[] args) {
        try {
            Encuentro enc = new Encuentro();
            enc.jugada();
        } catch(Mano e) {
        } catch(Lluvia e) {
        } catch(FutbolException e) {
        try {
            Partido par = new Encuentro();
            par.jugada();
        } catch(EquipoIncompleto e) {
        } catch(Falta e) {
        } catch(Lluvia e) {
        } catch(FutbolException e) {}
        }
    }
}
```

Hay varios errores:

1. Cuando Encuentro implementa a la interfaz Tormenta, está implementando a evento() dos veces, y una de ellas no tiene el throws. Esa se debería borrar.
2. Encuentro sobreescribe el método penal() que hereda de Partido, pero le agrega un throws que el método heredado no tenía. Esto no se puede hacer porque para sobreescribir un método se debe respetar la firma del método heredado.
3. catch(Lluvia e) nunca se ejecutará.

## 5. Analice el siguiente código:

```java
public class Suma {
    public static void main(String[] args) {
        int suma = 0;
        for(int i = 0; i <= args.length; i++)
            suma += Integer.parseInt(args[i]);
        System.out.print("La suma es: " + suma);
    }
}
```

### a) Ejecútelo ingresando al menos 2 valores.

Inicialmente se produce una excepción de IndexOutOfBounds, ya que se cometió un pequeño error en la declaración del bucle for: debe ser `i < args.length`, es decir menor estricto, no menor igual.

Luego de cambiar el <= por <, al ingresar por ejemplo 5, 12, 13, se obtiene su suma, 30.

### b) Ahora ejecútelo ingresando: 2 3 four. ¿Qué pasó? Solucione el problema de manera que los datos no numéricos sean impresos en la consola con un mensaje y descartados antes de ser sumados.

Se produce una excepción:

```
Exception in thread "main" java.lang.NumberFormatException: For input string: "four"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:661)
	at java.base/java.lang.Integer.parseInt(Integer.java:777)
	at Suma.main(Suma.java:5)
```

Solucionado en IntelliJ, proyecto 4.

### c) ¿Por qué no fue necesario capturar la excepción en el inciso a)?

En el inciso a) no fue necesario capturar la excepción porque no se produjo ninguna. Como ingresé números válidos en la lista de argumentos, el `parseInt` no tuvo problemas.
