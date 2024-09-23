import java.util.HashSet;

public class StringConverterSetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(1);
        set.add(3);
        set.add(10);
        StringConverterSet converter = new StringConverterSet(set);

        for (Object o : converter) {
            System.out.println(o + " " + o.getClass().getName());
        }
    }
}
