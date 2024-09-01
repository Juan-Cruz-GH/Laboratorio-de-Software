import java.util.Collection;
import java.util.HashSet;

public class HashSetAgregadosArreglado<E> {
    private int cantidadAgregados = 0;
    private HashSet<E> hashSet;

    public HashSetAgregadosArreglado() {
        hashSet = new HashSet<>();
    }

    public boolean add(E e) {
        cantidadAgregados++;
        return hashSet.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        cantidadAgregados += c.size();
        return hashSet.addAll(c);
    }

    public int getCantidadAgregados() {
        return cantidadAgregados;
    }
}
