package Práctica_1;

public abstract class FiguraGeometrica {
	protected String color;
	
	public FiguraGeometrica(String color) {
		this.color = color;
	}
	
	public abstract void dibujar();
	public abstract int area();

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
