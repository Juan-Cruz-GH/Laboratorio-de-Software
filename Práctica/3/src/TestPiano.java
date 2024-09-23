import java.util.AbstractMap.SimpleEntry;

public class TestPiano {
    public static void main(String[] args) {
        Piano piano = new Piano();

        System.out.println(piano.queEs());

        piano.hacerSonar();

        piano.hacerSonar(Notas.DO, 3);  // Toca la nota DO durante 3 segundos
        piano.hacerSonar(Notas.MI, 2);  // Toca la nota MI durante 2 segundos

        piano.afinar();

        piano.afinar(FrecuenciasDeLA.LA_440Hz);
        piano.afinar(FrecuenciasDeLA.LA_444Hz);

        SimpleEntry<Notas, Integer>[] notasConDuracion = new SimpleEntry[6];

        notasConDuracion[0] = new SimpleEntry<>(Notas.DO, 1);
        notasConDuracion[1] = new SimpleEntry<>(Notas.MI, 3);
        notasConDuracion[2] = new SimpleEntry<>(Notas.FA, 1);
        notasConDuracion[3] = new SimpleEntry<>(Notas.LA, 4);
        notasConDuracion[4] = new SimpleEntry<>(Notas.LA, 2);
        notasConDuracion[5] = new SimpleEntry<>(Notas.RE, 5);

        FitoPaez.FITO_PAEZ.tocarCancion(notasConDuracion);
    }
}
