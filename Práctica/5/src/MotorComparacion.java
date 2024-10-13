import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MotorComparacion {
    public ArrayList<String> comparar(DiccionarioGramas dict, String cadena) {
        Map<String, ArrayList<String>> gramas = dict.getGramas(cadena);
        return new ArrayList<>(Arrays.asList("a", "b"));
    }
}
