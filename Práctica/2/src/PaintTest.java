import java.util.Arrays;
import java.util.Comparator;

public class PaintTest {
	public static void main(String[] args) {
		Paint p = new Paint();
		p.init();
		FiguraGeometrica[] figuras = p.getPaleta();
		Arrays.sort(figuras, new ComparadorDeFiguras());
		for (FiguraGeometrica fg : figuras) {
			System.out.print("Área de la figura: " + fg.area());
			if (fg instanceof Circulo) {
				Circulo c = (Circulo)(fg);
				System.out.print(" Radio del circulo: " + c.getRadio());
			}
			System.out.println();
		}
	}
}
