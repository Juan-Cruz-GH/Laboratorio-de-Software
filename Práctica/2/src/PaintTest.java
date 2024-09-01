import java.util.Arrays;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class PaintTest {
	public static void main(String[] args) {
		Paint p = new Paint();
		p.init();
		FiguraGeometrica[] figuras = p.getPaleta();
		Arrays.sort(figuras, new ComparadorDeFiguras());

		// Serialización del array
		try (FileOutputStream fileOut = new FileOutputStream("figuras.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(figuras);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
