package me.zqpro.dsaa.linear.array;

/**
 * @author zhangqiang
 */
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public boolean add(int value) {
        if (size >= array.length) {
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            return false;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        --size;
        return true;
    }

    public void addAll(Iterable<? extends Integer> items) {
        for(Integer i : items) {
            add(i);
        }
    }
}
