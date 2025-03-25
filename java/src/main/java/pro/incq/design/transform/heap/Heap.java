package pro.incq.design.transform.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {

    private final int[] data = new int[100];

    private int size;

    public Heap() {
    }

    public int take() {
        if (size <= 0) {
            throw new NoSuchElementException();
        }
        int v = data[0];
        size--;
        // shift down
        if (size > 0) {
            int k = 0;
            int x = data[k];
            while(k < size) {
                int c1 = k * 2 + 1;
                if (c1 + 1 < size && data[c1] < data[c1 + 1]) {
                    c1 = c1 + 1;
                }
                if (c1 < size &&
            }
        }

        return v;
    }

    public int size() {
        return size;
    }

    public void add(int e) {
        int k = size;
        size++;
        while (k > 0 ) {
            int parent = (k - 1) / 2;
            if (data[parent] < e) {
                data[k] = data[parent];
                k = parent;
            } else {
                break;
            }
        }
        data[k] = e;
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(4);
        h.add(3);
        h.add(2);
        h.add(1);
        System.out.println(h.size());
        for(int i = 0; i < h.size(); i++) {
            System.out.println(h.take());
        }
//        System.out.println(Arrays.toString(h.data));
    }
}
