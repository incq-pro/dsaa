package me.zqpro.dsaa.heap;


/**
 * 大顶堆
 *
 * @author yun.516@gmail.com
 */
public class IntHeap {
    private int[] data;
    private int size;

    public IntHeap(int capacity) {
        data = new int[capacity];
    }

    public boolean add(int v) {
        if (size >= data.length) {
            return false;
        }
        int i = size++;
        data[i] = v;
        heapifyDownUp(data, i);
        return true;
    }

    public int popHead() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int ret = data[0];
        data[0] = data[--size];
        heapifyUpDown(data, size - 1, 0);
        return ret;
    }

    public static void sort(int[] a) {
        buildHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            heapifyUpDown(a, i - 1, 0);
        }
    }

    private static void buildHeap(int[] a) {
        final int n = a.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapifyUpDown(a, n, i);
        }
    }

    private static void heapifyDownUp(int[] a, int i) {
        int p = parent(i);
        while (i > 0 && a[p] < a[i]) {
            swap(a, p, i);
            i = p;
            p = parent(i);
        }
    }

    private static void heapifyUpDown(int[] a, int n, int i) {
        while (true) {
            int maxI = i;
            int left = left(i);
            if (left <= n && a[left] > a[maxI]) {
                maxI = left;
            }
            int right = right(i);
            if (right <= n && a[right] > a[maxI]) {
                maxI = right;
            }
            if (maxI == i) {
                break;
            }
            swap(a, i, maxI);
            i = maxI;
        }
    }

    private static int left(int i) {
        return (i << 1) + 1;
    }

    private static int right(int i) {
        return (i << 1) + 2;
    }

    private static int parent(int i) {
        return (i - 1) >> 1;
    }

    private static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
