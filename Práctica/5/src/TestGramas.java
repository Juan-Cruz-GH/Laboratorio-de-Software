import java.util.*;

public class TestGramas {
    public static void main(String[] args) {
        DiccionarioGramas diccionarioGramas = new DiccionarioGramas();
        MotorComparacion motorComparacion = new MotorComparacion();
        motorComparacion.comparar(diccionarioGramas, "Glucosa");
    }
}
