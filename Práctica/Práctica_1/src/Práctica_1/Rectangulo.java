package Práctica_1;

public class Rectangulo extends FiguraGeometrica {
	private int alto;
	private int ancho;
	
	public Rectangulo(int alto, int ancho, String color) {
		super(color);
		this.alto = alto;
		this.ancho = ancho;
	}
	
	@Override
	public void dibujar() {
		System.out.println("Se dibuja un rectángulo de alto " + alto + ", de ancho " + ancho + " y de color " + color);
	}

	@Override
	public int area() {
		return alto * ancho;
	}

}
