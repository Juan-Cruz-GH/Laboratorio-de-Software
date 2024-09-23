public enum FrecuenciasDeLA {
    LA_440Hz("Organización Internacional de Estandarización ISO 16"),
    LA_444Hz("Afinación de cámara"),
    LA_446Hz("Renacimiento"),
    LA_480Hz("Órganos alemanes que tocaba Bach");

    private final String tipoFrecuencia;

    FrecuenciasDeLA(String tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }
}
