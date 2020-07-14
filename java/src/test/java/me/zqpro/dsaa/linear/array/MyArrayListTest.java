package me.zqpro.dsaa.linear.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testInit() {
        MyArrayList<Integer> a = new MyArrayList<>(1);
        assertEquals(0, a.size());
        assertTrue(a.isEmpty());
    }

    @Test
    public void testAdd() {
        MyArrayList<Integer> a = new MyArrayList<>(10);
        assertTrue(a.add(1));
        assertEquals(Integer.valueOf(1), a.get(0));
        a.add(a.size(), 20);
        assertEquals(Integer.valueOf(20), a.get(a.size() - 1));

        MyArrayList<Integer> a2 = new MyArrayList<>(1);
        a2.add(0, 1);
        a2.add(0, 2);
        assertTrue(a2.contains(1));
        assertTrue(a2.contains(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds1() {
        MyArrayList<Integer> a = new MyArrayList<>(1);
        a.add(-1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds2() {
        MyArrayList<Integer> a = new MyArrayList<>(1);
        a.add(1, 1);
    }

    @Test
    public void testDelete() {
        MyArrayList<Integer> a = new MyArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            a.add(i, i);
        }
        assertEquals(Integer.valueOf(0), a.get(0));
        assertEquals(Integer.valueOf(1), a.get(1));
        a.remove(0);
        assertEquals(Integer.valueOf(1), a.get(0));
    }
}
