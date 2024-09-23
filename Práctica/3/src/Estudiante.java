public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private int legajo;
    private int materiasAprobadas;
    public Estudiante(String nombre, String apellido, int edad, int legajo, int materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(int materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " tiene " + edad + " años, su legajo es " + legajo + " y ha aprobado " + materiasAprobadas + " materias.";
    }
}
