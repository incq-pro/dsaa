package me.zqpro.dsaa.heap;

/**
 * @author yun.516@gmail.com
 */
public class BigHeap<T extends Comparable<T>> extends Heap<T> {

    public BigHeap(int capacity) {
        super(capacity);
    }

    @Override
    int compare(T a, T b) {
        return -a.compareTo(b);
    }
}
