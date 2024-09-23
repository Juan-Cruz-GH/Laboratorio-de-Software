import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;

public class StringConverterSet extends AbstractSet {
    private HashSet set;

    public StringConverterSet(HashSet set) {
        this.set = set;
    }

    @Override
    public IteratorStringAdapter iterator() {
        return new IteratorStringAdapter(set.iterator());
    }

    @Override
    public int size() {
        return set.size();
    }

    private class IteratorStringAdapter implements Iterator {
        private Iterator<String> iterator;
        public IteratorStringAdapter(Iterator iterator) {
            this.iterator = iterator;
        }
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public String next() {
            return String.valueOf(iterator.next());
        }
    }
}
