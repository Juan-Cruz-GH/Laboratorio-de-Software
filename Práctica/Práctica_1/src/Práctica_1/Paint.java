package Práctica_1;

public class Paint {
	private FiguraGeometrica[] paleta;
	
	public Paint() {
		paleta = new FiguraGeometrica[4];
	}
	
	public void setPaleta(FiguraGeometrica[] paleta) {
		this.paleta = paleta;
	}
	
	public FiguraGeometrica[] getPaleta() {
		return paleta;
	}
	
	public void init() {
		paleta[0] = new Circulo(2, "azul");
		paleta[1] = new Circulo(3, "amarillo");
		
		paleta[2] = new Rectangulo(2, 3, "verde");
		paleta[3] = new Rectangulo(4, 10, "rojo");
	}
}
