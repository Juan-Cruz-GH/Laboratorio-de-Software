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
### b) Analice el código de la interface y las clases que la implementan. Determine si son legales o no. En caso de ser necesario, realice las correcciones que correspondan. ¿Cómo podría modificar el acceso afinar() para evitar realizar cambios en las clases que implementan IntrumentoMusical?
...

