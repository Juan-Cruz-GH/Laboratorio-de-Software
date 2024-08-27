package Práctica_1;

public class Vacuna {
	private String marca;
	private String paisDeOrigen;
	private String enfermedadPrevenida;
	private int cantidadDosis;
	
	
	public Vacuna(String marca, String paisDeOrigen, String enfermedadPrevenida, int cantidadDosis) {
		super();
		this.marca = marca;
		this.paisDeOrigen = paisDeOrigen;
		this.enfermedadPrevenida = enfermedadPrevenida;
		this.cantidadDosis = cantidadDosis;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}


	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}


	public String getEnfermedadPrevenida() {
		return enfermedadPrevenida;
	}


	public void setEnfermedadPrevenida(String enfermedadPrevenida) {
		this.enfermedadPrevenida = enfermedadPrevenida;
	}


	public int getCantidadDosis() {
		return cantidadDosis;
	}


	public void setCantidadDosis(int cantidadDosis) {
		this.cantidadDosis = cantidadDosis;
	}

	@Override
	public String toString() {
		StringBuffer datosVacuna = new StringBuffer("Vacuna con marca: ");
		datosVacuna.append(marca);
		datosVacuna.append(", pais de origen: ");
		datosVacuna.append(paisDeOrigen);
		datosVacuna.append(", enfermedad prevenida: ");
		datosVacuna.append(enfermedadPrevenida);
		datosVacuna.append(" y cantidad de dosis: ");
		datosVacuna.append(cantidadDosis);
		return datosVacuna.toString();
	}

}
