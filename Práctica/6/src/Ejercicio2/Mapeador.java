package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Mapeador {
    private static String obtenerNombreArchivo(Archivo anotacionArchivo, Class<?> clase) {
        /*
        Si la anotación posee un nombre de archivo, se utiliza ese.
        Si no, se utiliza el nombre de la clase concatenado con ".txt".
         */
        String nombre = anotacionArchivo.name();
        if (!nombre.isEmpty()) {
            return nombre;
        }
        else {
            return clase.getSimpleName() + ".txt";
        }
    }

    public static void almacenar(Object objeto) {
        /*

         */
        Class<?> clase = objeto.getClass();

        // Verificar si la clase tiene la anotación @Ejercicio3.Archivo
        if (!clase.isAnnotationPresent(Archivo.class)) {
            throw new IllegalStateException("La clase " + clase.getSimpleName() + " no posee la anotación @Ejercicio3.Archivo.");
        }

        // Obtener el nombre del archivo desde la anotación @Ejercicio3.Archivo o usar el nombre de la clase
        String nombreArchivo = obtenerNombreArchivo(clase.getAnnotation(Archivo.class), clase);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir el nombre de la clase
            writer.write("<nombreClase>" + clase.getSimpleName() + "</nombreClase>\n");

            // Iterar sobre los campos de la clase y escribir los anotados con @Ejercicio3.AlmacenarAtributo
            for (Field campo : clase.getDeclaredFields()) {
                if (campo.isAnnotationPresent(AlmacenarAtributo.class)) {
                    campo.setAccessible(true);
                    String nombreAtributo = campo.getName();
                    Object valorAtributo = campo.get(objeto);

                    writer.write("<nombreAtributo>" + nombreAtributo + "</nombreAtributo>\n");
                    writer.write("<nombreValor>" + valorAtributo + "</nombreValor>\n");
                }
            }

            System.out.println("Ejercicio3.Archivo creado exitosamente en: " + nombreArchivo);

        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Mapeado mapeado = new Mapeado();
        Mapeador.almacenar(mapeado);
    }
}
