package array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayTest {

    @Test
    public void testInit() {
        MyArray a = new MyArray(1);
        assertEquals(0, a.size());
    }

    @Test
    public void testInsert() {
        MyArray a = new MyArray(10);
        assertTrue(a.insert(0, 1));
        assertEquals(1, a.get(0));
        assertTrue(a.insert(a.size(), 20));
        assertEquals(20, a.get(a.size() - 1));

        MyArray a2 = new MyArray(1);
        assertTrue(a2.insert(0, 1));
        assertFalse(a2.insert(0, 2));

        MyArray a3 = new MyArray(2);
        assertTrue(a3.insert(0, 1));
        assertTrue(a3.insert(0, 2));
        assertFalse(a3.insert(0, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds1() {
        MyArray a = new MyArray(1);
        a.insert(-1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds2() {
        MyArray a = new MyArray(1);
        a.insert(1, 1);
    }

    @Test
    public void testDelete() {
        MyArray a = new MyArray(5);
        for (int i = 0; i < 5; i++) {
            assertTrue(a.insert(i, i));
        }
        assertEquals(0, a.get(0));
        assertEquals(1, a.get(1));
        a.delete(0);
        assertEquals(1, a.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBounds1() {
        MyArray a = new MyArray(5);
        a.delete(0);
    }
}
