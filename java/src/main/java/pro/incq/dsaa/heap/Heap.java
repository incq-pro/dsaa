package pro.incq.dsaa.heap;

/**
 * @author yun.516@gmail.com
 */
public abstract class Heap<T extends Comparable<T>> {
    T[] data;
    int size = 0;

    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        data = (T[]) new Comparable[capacity];
    }

    public int size() {
        return this.size;
    }

    public void add(T v) {
        if (size < data.length) {
            int i = size++;
            data[i] = v;
            heapifyDownUp(i);
        } else {
            data[0] = v;
            heapifyUpDown(size - 1, 0);
        }
    }

    public T getHead() {
        if (size <= 0) {
            return null;
        }
        return data[0];
    }

    public T popHead() {
        if (size <= 0) {
            return null;
        }
        T ret = data[0];
        data[0] = data[--size];
        heapifyUpDown(size - 1, 0);
        return ret;
    }

    void heapifyDownUp(int i) {
        int p = parent(i);
        while (i > 0 && compare(data[i], data[p]) < 0) {
            swap(data, i, p);
            i = p;
            p = parent(i);
        }
    }

    void heapifyUpDown(int n, int i) {
        while (true) {
            int minI = i;
            int left = left(i);
            if (left <= n && compare(data[left], data[minI]) < 0) {
                minI = left;
            }
            int right = right(i);
            if (right <= n && compare(data[right], data[minI]) < 0) {
                minI = right;
            }
            if (minI == i) {
                break;
            }
            swap(data, i, minI);
            i = minI;
        }
    }

    abstract int compare(T a, T b);

    private static int left(int i) {
        return (i << 1) + 1;
    }

    private static int right(int i) {
        return (i << 1) + 2;
    }

    private static int parent(int i) {
        return (i - 1) >> 1;
    }

    private static <T> void swap(T[] a, int l, int r) {
        T tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
