import java.util.*;
import java.util.stream.Collectors;

public class Facultad {
    private class Ordenador implements Comparator<Alumno> {
        public int compare(Alumno a1, Alumno a2) {
            return Integer.compare(a2.getNotaAprobacion(), a1.getNotaAprobacion());
        }
    }

    private ArrayList<Alumno> alumnos;

    public Facultad() {
        alumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    public Alumno alumnoConMayorNota() {
        return Collections.max(alumnos, Comparator.comparingInt(alumno -> alumno.getNotaAprobacion()));
    }

    public void imprimirDosEstudiantes() {
        Random random = new Random();
        System.out.println("\n 2 alumnos aleatorios:");
        System.out.println(alumnos.get(random.nextInt(alumnos.size())));
        System.out.println(alumnos.get(random.nextInt(alumnos.size())));
    }

    public Alumno alumnoQueCursoLabo() {
        return alumnos.stream()
                .filter(alumno -> alumno.getMateriaAprobada().equals("Laboratorio de Software"))
                .findFirst()
                .orElse(null);
    }

    public List<Alumno> alumnosConPYLongitudMenorA6() {
        return alumnos.stream()
                .filter(alumno -> alumno.getNombre().startsWith("P") && alumno.getNombre().length() <= 6)
                .collect(Collectors.toList());
    }

    public ArrayList<Alumno> ordenarPorNota() {
        ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(alumnos);
        Collections.sort(alumnosOrdenados, Comparator.comparingInt(Alumno::getNotaAprobacion));
        return alumnosOrdenados;
    }
}


