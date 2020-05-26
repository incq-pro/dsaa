package me.zqpro.dsaa.linear.array;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * excise for ArrayList
 *
 * @author yun.516@gmail.com
 */
public class MyArrayList<E> {

    /**
     * default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * the array holding the elements
     */
    private E[] items;

    /**
     * size of list
     */
    private int size;

    public MyArrayList() {
        doClear(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        doClear(initialCapacity);
    }

    public MyArrayList(Collection<? extends E> c) {
        doClear(c.size());
        for (E e : c) {
            items[size++] = e;
        }
    }

    public boolean add(E e) {
        checkSize();
        items[size++] = e;
        return true;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        checkSize();
        for (int i = size - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = e;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    public void clear() {
        doClear(DEFAULT_CAPACITY);
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (items != null && minCapacity <= items.length) {
            return;
        }
        E[] items = (E[]) new Object[minCapacity];
        if (this.items != null) {
            System.arraycopy(this.items, 0, items, 0, size);
        }
        this.items = items;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E e = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return e;
    }

    public boolean remove(Object o) {
        for(int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                for(int j = i; j < size -1; j++) {
                    items[j] = items[j+1];
                }
                return true;
            }
        }
        return false;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E ret = items[index];
        items[index] = e;
        return ret;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize() {
        E[] items = (E[]) new Object[size];
        System.arraycopy(this.items, 0, items, 0, size);
        this.items = items;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    @SuppressWarnings("unchecked")
    private void doClear(int capacity) {
        size = 0;
        this.items = (E[]) new Object[capacity];
    }

    private void checkSize() {
        if (size >= items.length) {
            ensureCapacity(items.length * 2);
        }
    }
}
