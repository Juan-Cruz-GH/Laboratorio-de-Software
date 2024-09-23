import java.util.AbstractMap.SimpleEntry;

public enum FitoPaez {
    FITO_PAEZ;
    private final Piano piano = new Piano();

    public void tocarCancion(SimpleEntry<Notas, Integer>[] notasConDuracion) {
        System.out.println("Fito Paez va a tocar una canción:");
        for (int i = 0; i < notasConDuracion.length; i++) {
            Notas nota = notasConDuracion[i].getKey();
            int duracion = notasConDuracion[i].getValue();
            piano.hacerSonar(nota, duracion);
        }
    }
}
