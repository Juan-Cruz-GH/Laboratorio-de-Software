import java.util.Arrays;

public class HashSetAgregadosTest {
    public static void main(String[] args) {
        HashSetAgregados<String> hashSet = new HashSetAgregados<String>();

        hashSet.add("uno");
        hashSet.add("dos");

        System.out.println("Luego de hacer dos add(), hashSet tiene: " + hashSet.getCantidadAgregados() + " elementos.");

        String[] textos = {"tres", "cuatro", "cinco"};
        hashSet.addAll(Arrays.asList(textos));

        System.out.println("Luego de hacer un addAll() de un array de 3 elementos, hashSet tiene: " + hashSet.getCantidadAgregados() + " elementos.");

        HashSetAgregadosArreglado<String> hashSet2 = new HashSetAgregadosArreglado<String>();

        hashSet2.add("uno");
        hashSet2.add("dos");

        System.out.println("Luego de hacer dos add(), hashSetArreglado tiene: " + hashSet2.getCantidadAgregados() + " elementos.");

        String[] textos2 = {"tres", "cuatro", "cinco"};
        hashSet2.addAll(Arrays.asList(textos2));

        System.out.println("Luego de hacer un addAll() de un array de 3 elementos, hashSet tiene: " + hashSet2.getCantidadAgregados() + " elementos.");
    }
}
