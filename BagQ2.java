import java.util.ArrayList;
import java.util.List;

public class BagQ2<T> {
    private List<T> items;

    public BagQ2() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for Bag size " + items.size());
        }
        return items.get(index);
    }
}