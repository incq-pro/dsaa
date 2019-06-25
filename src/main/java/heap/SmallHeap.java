package heap;

/**
 * @author yun.516@gmail.com
 */
public class SmallHeap<T extends Comparable<T>> extends Heap<T> {
    public SmallHeap(int capacity) {
        super(capacity);
    }

    @Override
    int compare(T a, T b) {
        return a.compareTo(b);
    }
}
