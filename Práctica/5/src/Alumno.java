public class Alumno {
    private int numAlumno;
    private String nombre;
    private String apellido;
    private int edad;
    private String materiaAprobada;
    private int notaAprobacion;

    public Alumno(int numAlumno, String nombre, String apellido, int edad, String materiaAprobada, int notaAprobacion) {
        this.numAlumno = numAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.materiaAprobada = materiaAprobada;
        this.notaAprobacion = notaAprobacion;
    }

    public int getNotaAprobacion() {
        return notaAprobacion;
    }

    public String getMateriaAprobada() {
        return materiaAprobada;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numAlumno=" + numAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", materiaAprobada='" + materiaAprobada + '\'' +
                ", notaAprobacion=" + notaAprobacion +
                '}';
    }
}
