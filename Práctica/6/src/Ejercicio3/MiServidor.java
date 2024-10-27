package Ejercicio3;

@Servidor(direccion="127.0.0.1", puerto=8080, archivo="info-login.txt")
public class MiServidor {
    @Invocar
    public void saludo() {
        System.out.println("Bienvenido al servidor!");
    }

    @Invocar
    public void despedida() {
        System.out.println("Hasta luego!");
    }
}
