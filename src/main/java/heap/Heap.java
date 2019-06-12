package heap;

/**
 * @author yun.516@gmail.com
 */
public class Heap {
    private int[] a;
    private int size;

    public Heap(int capacity) {
        a = new int[capacity];
        size = 0;
    }

    public boolean insert(int data) {
        if (size >= a.length) {
            return false;
        }
        a[size++] = data;
        heapifyDownUp(a, size - 1);
        return true;
    }

    public int popHead() {
        if (size <= 0) {
            return -1;
        }
        int ret = a[0];
        a[0] = a[--size];
        heapify(a, size, 0);
        return ret;
    }

    public static void sort(int[] a) {
        buildHeap(a, a.length);
        // i is last_pos-1
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    private static void heapify(final int[] a, final int n, int i) {
        while (true) {
            int maxPos = i;
            if (left(i) < n && a[left(i)] > a[i]) {
                maxPos = left(i);
            }
            if (right(i) < n && a[right(i)] > a[maxPos]) {
                maxPos = right(i);
            }
            if (maxPos == i) {
                return;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void heapifyDownUp(int[] a, int i) {
        while (parent(i) >= 0 && a[i] > a[parent(i)]) {
            swap(a, i, parent(i));
            i = parent(i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }
}
