public class Alumnoo {
    private int legajo;
    private String nombre;
    private String apellido;
    private int DNI;

    public Alumnoo(int legajo, String nombre, String apellido, int DNI) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Alumno con " +
                "legajo " + legajo +
                ", nombre " + nombre +
                ", apellido " + apellido +
                " y DNI " + DNI;
    }
}
