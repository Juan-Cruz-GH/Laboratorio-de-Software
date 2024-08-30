import java.util.Arrays;

public class HashSetAgregadosTest {
    public static void main(String[] args) {
        HashSetAgregados<String> hashSet = new HashSetAgregados<String>();

        hashSet.add("uno");
        hashSet.add("dos");

        System.out.println("Test 1: " + hashSet.getCantidadAgregados());

        String[] textos = {"tres", "cuatro", "cinco"};
        hashSet.addAll(Arrays.asList(textos));

        System.out.println("Test 2: " + hashSet.getCantidadAgregados());
    }
}
