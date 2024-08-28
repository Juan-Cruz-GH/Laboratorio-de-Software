public class PaintTest {

	public static void main(String[] args) {
		Paint p = new Paint();
		p.init();
		for (FiguraGeometrica fg : p.getPaleta()) {
			System.out.print("Área de la figura: " + fg.area());
			if (fg instanceof Circulo) {
				Circulo c = (Circulo)(fg);
				System.out.print(" Radio del circulo: " + c.getRadio());
			}
			System.out.println();
		}
	}
}
