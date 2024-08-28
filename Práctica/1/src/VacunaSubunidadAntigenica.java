public class VacunaSubunidadAntigenica extends Vacuna {
	private int cantidadAntigenos;
	private String tipoProceso;
	
	public int getCantidadAntigenos() {
		return cantidadAntigenos;
	}
	public void setCantidadAntigenos(int cantidadAntigenos) {
		this.cantidadAntigenos = cantidadAntigenos;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	
	public VacunaSubunidadAntigenica(String marca, String paisDeOrigen, String enfermedadPrevenida, int cantidadDosis, int cantidadAntigenos, String tipoProceso) {
		super(marca, paisDeOrigen, enfermedadPrevenida, cantidadDosis);
		this.cantidadAntigenos = cantidadAntigenos;
		this.tipoProceso = tipoProceso;
	}
	
}
