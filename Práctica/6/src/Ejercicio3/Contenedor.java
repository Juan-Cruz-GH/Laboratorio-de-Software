package Ejercicio3;

import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.time.LocalDateTime;

public class Contenedor {
    public void iniciarServidor(Class<?> claseServidor) throws Exception {
        if (!claseServidor.isAnnotationPresent(Servidor.class)) {
            throw new IllegalArgumentException("La clase no está anotada con @Servidor");
        }

        // Obtener datos de la anotación @Servidor
        Servidor servidorInfo = claseServidor.getAnnotation(Servidor.class);
        String direccion = servidorInfo.direccion();
        int puerto = servidorInfo.puerto();
        String archivoLog = servidorInfo.archivo();

        // Iniciar el servidor en el puerto especificado
        try (ServerSocket serverSocket = new ServerSocket(puerto, 0, InetAddress.getByName(direccion))) {
            System.out.println("Servidor iniciado en " + direccion + ":" + puerto);

            while (true) {
                // Esperar conexiones
                Socket cliente = serverSocket.accept();
                String ipCliente = cliente.getInetAddress().getHostAddress();
                logConexion(ipCliente, archivoLog);

                // Instanciar la clase y ejecutar los métodos anotados con @Invocar
                Object instanciaServidor = claseServidor.getDeclaredConstructor().newInstance();
                for (Method metodo : claseServidor.getDeclaredMethods()) {
                    if (metodo.isAnnotationPresent(Invocar.class)) {
                        metodo.invoke(instanciaServidor);
                    }
                }

                // Responder al cliente y cerrar conexión
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                out.println("HTTP/1.1 200 OK\r\n");
                out.println("Content-Type: text/plain\r\n");
                out.println("\r\n");
                out.println("Petición recibida y procesada. Gracias por conectarte!");
                cliente.close();
            }
        }
    }

    private void logConexion(String ipCliente, String archivoLog) {
        try (FileWriter writer = new FileWriter(archivoLog, true)) {
            writer.write("Fecha: " + LocalDateTime.now() + " - IP Cliente: " + ipCliente + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Contenedor contenedor = new Contenedor();
        contenedor.iniciarServidor(MiServidor.class);
    }
}
