import java.util.*;

public class TestFacultad {
    public static void main(String[] args) {
        Facultad facultad = new Facultad();
        facultad.agregarAlumno(new Alumno(170727, "Juan Cruz", "Cassera Botta", 23, "Laboratorio de Software", 9));
        facultad.agregarAlumno(new Alumno(170728, "Martina", "Rodríguez Pérez", 23, "CADP", 5));
        facultad.agregarAlumno(new Alumno(170729, "Lucía", "González Serrano", 20, "ISO", 10));
        facultad.agregarAlumno(new Alumno(170730, "Tomás", "Martínez López", 24, "AyED", 8));
        facultad.agregarAlumno(new Alumno(170731, "Agustín", "García Ramírez", 21, "Mate 4", 7));
        facultad.agregarAlumno(new Alumno(170732, "Sofía", "López Morales", 22, "Mate 2", 7));
        facultad.agregarAlumno(new Alumno(170733, "Pablo", "Fernández Castro", 21, "ISO", 6));
        facultad.agregarAlumno(new Alumno(170734, "Pedro", "Pérez Gómez", 22, "CADP", 4));
        facultad.agregarAlumno(new Alumno(170735, "Facundo", "Sánchez Díaz", 25, "Proyecto de Software", 7));
        facultad.agregarAlumno(new Alumno(170736, "Camila", "Ramírez Méndez", 31, "DBD", 8));

        System.out.println("Alumno con mayor nota:\n" + facultad.alumnoConMayorNota());
        facultad.imprimirDosEstudiantes();

        System.out.println("\n Alumno que cursó Laboratorio de Software:\n" + facultad.alumnoQueCursoLabo());
        ArrayList<Alumno> alumnosCondicion = (ArrayList<Alumno>) facultad.alumnosConPYLongitudMenorA6();

        System.out.println("\n Alumnos cuyo nombre empieza con P y su longitud es menor o igual a 6 caractéres:");
        for (Alumno alumno : alumnosCondicion) {
            System.out.println(alumno);
        }

        System.out.println("\n Alumnos ordenados por nota:");
        for (Alumno alumno : facultad.ordenarPorNota()) {
            System.out.println(alumno);
        }
    }
}
