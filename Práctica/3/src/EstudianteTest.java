import java.util.Arrays;
import java.util.Comparator;

public class EstudianteTest {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Juan", "Cassera", 23, 17072, 26);
        Estudiante e2 = new Estudiante("Carla", "Rodriguez", 21, 15067, 15);
        Estudiante e3 = new Estudiante("Matias", "Trota", 30, 12666, 20);
        Estudiante e4 = new Estudiante("Matias", "Gonzalez", 19, 18933, 10);
        Estudiante e5 = new Estudiante("Gonzalo", "Gutierrez", 26, 13551, 30);

        Estudiante[] estudiantes = {e1, e2, e3, e4, e5};

        System.out.println("Imprimir estudiantes ordenado por cantidad de materias aprobadas en forma ascendente.\n");
        Arrays.sort(estudiantes, new Comparator<>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e1.getMateriasAprobadas(), e2.getMateriasAprobadas());
            }
        });
        for(Estudiante est : estudiantes) {
            System.out.println(est);
        };
        System.out.println();

        System.out.println("Imprimir estudiantes ordenado por edad en forma descendente.\n");
        Arrays.sort(estudiantes, new Comparator<>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e2.getEdad(), e1.getEdad());
            }
        });
        for(Estudiante est : estudiantes) {
            System.out.println(est);
        };
        System.out.println();

        System.out.println("Imprimir estudiantes ordenado por legajo en forma ascendente.\n");
        Arrays.sort(estudiantes, new Comparator<>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e1.getLegajo(), e2.getLegajo());
            }
        });
        for(Estudiante est : estudiantes) {
            System.out.println(est);
        };
        System.out.println();

        System.out.println("Imprimir estudiantes ordenado por nombre y apellido en forma descendente.\n");
        Arrays.sort(estudiantes, new Comparator<>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                // Comparar por nombre primero
                int comparacionNombre = e2.getNombre().compareTo(e1.getNombre());
                // Si los nombres son distintos, se usa esa comparación
                if (comparacionNombre != 0) {
                    return comparacionNombre;
                }
                // Si los nombres son iguales, comparar por apellido
                return e2.getApellido().compareTo(e1.getApellido());
            }
        });
        for(Estudiante est : estudiantes) {
            System.out.println(est);
        };
        System.out.println();
    }
}
