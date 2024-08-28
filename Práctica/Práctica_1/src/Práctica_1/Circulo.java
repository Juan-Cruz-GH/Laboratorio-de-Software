package Práctica_1;

public class Circulo extends FiguraGeometrica {
	private int radio;
	
	public Circulo(int radio, String color) {
		super(color);
		this.radio = radio;
	}
	
	@Override
	public void dibujar() {
		System.out.println("Se dibuja un circulo de radio " + radio + " y de color " + color);
	}
	
	@Override
	public int area() {
		double radioCuadrado = Math.pow(radio, 2);
		return (int)(Math.PI * radioCuadrado);
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public int getRadio() {
		return radio;
	}
}
