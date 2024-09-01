import java.io.Serializable;

public abstract class FiguraGeometrica implements Serializable {
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
