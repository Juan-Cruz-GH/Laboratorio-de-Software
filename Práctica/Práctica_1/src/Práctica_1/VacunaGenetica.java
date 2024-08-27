package Práctica_1;

public class VacunaGenetica extends Vacuna {
	private int temperaturaMinima;
	private int temperaturaMaxima;
	
	public int getTemperaturaMinima() {
		return temperaturaMinima;
	}
	public void setTemperaturaMinima(int temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
	public int getTemperaturaMaxima() {
		return temperaturaMaxima;
	}
	public void setTemperaturaMaxima(int temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
	public VacunaGenetica(String marca, String paisDeOrigen, String enfermedadPrevenida, int cantidadDosis, int temperaturaMinima, int temperaturaMaxima) {
		super(marca, paisDeOrigen, enfermedadPrevenida, cantidadDosis);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}
}
