import java.util.HashSet;
import java.util.Set;

public class SetEspecial<E> {
    Set<E> set;
    private int elementosRemovidos = 0;

    public SetEspecial() {
        this.set = new HashSet<E>();
    }

    public int getElementosRemovidos() {
        return elementosRemovidos;
    }

    public void add(E e) {
        this.set.add(e);
    }

    public void remove(E e) {
        this.set.remove(e);
        this.elementosRemovidos++;
    }
}
