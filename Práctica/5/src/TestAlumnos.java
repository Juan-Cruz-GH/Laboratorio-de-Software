public class TestAlumnos {
    public static void main(String[] args) {
        Materia labo = new Materia("Laboratorio de Software");
        labo.agregaAlumno(new Alumnoo(170727, "Juan Cruz", "Cassera Botta", 43471586));
        labo.agregaAlumno(new Alumnoo(170728, "Martina", "Rodríguez Pérez", 43521687));
        labo.agregaAlumno(new Alumnoo(170729, "Lucía", "González Serrano", 43871923));
        labo.agregaAlumno(new Alumnoo(170730, "Tomás", "Martínez López", 43652874));
        labo.agregaAlumno(new Alumnoo(170731, "Agustín", "García Ramírez", 43912234));
        labo.agregaAlumno(new Alumnoo(170732, "Sofía", "López Morales", 43731895));
        labo.agregaAlumno(new Alumnoo(170733, "Matías", "Fernández Castro", 43362154));
        labo.agregaAlumno(new Alumnoo(170734, "Valentina", "Pérez Gómez", 43482516));
        labo.agregaAlumno(new Alumnoo(170735, "Facundo", "Sánchez Díaz", 43211897));
        labo.agregaAlumno(new Alumnoo(170736, "Camila", "Ramírez Méndez", 43152783));
        System.out.println("Alumnos de la materia " + labo.getNombre() + ":" + "\n");
        for(Alumnoo a : labo.getAlumnos()) {
            System.out.println(a);
        }
    }
}
