import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack {
    private ArrayList items;
    public Stack() {
        items = new ArrayList();
    }
    public void push(Object item) {
        items.add(item);
    }
    public Object pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Object item = items.getLast();
        items.remove(item);
        return item;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public class StackIterator implements Iterator {
        private int currentIndex = items.size() - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            return items.get(currentIndex--);
        }
    }

}
