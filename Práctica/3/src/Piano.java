public class Piano implements InstrumentoMusical {

    @Override
    public void hacerSonar() {
        System.out.println("Piano sonando.");
    }

    @Override
    public void hacerSonar(Notas n, int duracion) {
        System.out.println("Tocando nota " + n + " durante " + duracion + " segundos.");
    }

    @Override
    public String queEs() {
        return "Un piano.";
    }

    @Override
    public void afinar() {
        System.out.println("Piano afinando.");
    }

    @Override
    public void afinar(FrecuenciasDeLA f) {
        System.out.println("Piano afinando con frecuencia: " + f);
    }
}
