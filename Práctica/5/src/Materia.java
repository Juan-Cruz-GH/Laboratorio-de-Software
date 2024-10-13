import java.util.ArrayList;
import java.util.Comparator;

public class Materia {
    private String nombre;
    private ArrayList<Alumnoo> alumnos;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregaAlumno(Alumnoo a) {
        alumnos.add(a);
        alumnos.sort(Comparator.comparing(Alumnoo::getLegajo));
    }

    public ArrayList<Alumnoo> getAlumnos() {
        return alumnos;
    }
}
