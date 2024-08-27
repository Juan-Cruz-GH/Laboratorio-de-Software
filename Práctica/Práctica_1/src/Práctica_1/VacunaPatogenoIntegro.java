package Práctica_1;

public class VacunaPatogenoIntegro extends Vacuna {
	private String virusPatogeno;

	public String getVirusPatogeno() {
		return virusPatogeno;
	}

	public void setVirusPatogeno(String virusPatogeno) {
		this.virusPatogeno = virusPatogeno;
	}

	public VacunaPatogenoIntegro(String marca, String paisDeOrigen, String enfermedadPrevenida, int cantidadDosis, String virusPatogeno) {
		super(marca, paisDeOrigen, enfermedadPrevenida, cantidadDosis);
		this.virusPatogeno = virusPatogeno;
	}
	
}
