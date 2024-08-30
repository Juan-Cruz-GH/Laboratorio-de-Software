import java.util.Comparator;

public class ComparadorDeFiguras implements Comparator<FiguraGeometrica> {
    @Override
    public int compare(FiguraGeometrica figura1, FiguraGeometrica figura2) {
        return Integer.compare(figura1.area(), figura2.area());
    }
}
