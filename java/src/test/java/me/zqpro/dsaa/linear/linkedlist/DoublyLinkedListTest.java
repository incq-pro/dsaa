package me.zqpro.dsaa.linear.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author yun.516@gmail.com
 */
public class DoublyLinkedListTest {
    @Test
    public void testInit() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        DoublyLinkedList l = new DoublyLinkedList();
        for (int i = 0; i < 10; i++) {
            assertTrue(l.add(i));
        }
        assertEquals(10, l.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, l.get(i));
        }
    }

    @Test
    public void testInsert() {
        DoublyLinkedList l = new DoublyLinkedList();
        assertTrue(l.insert(0, 10));
        assertEquals(1, l.size());
        assertEquals(10, l.get(0));

        assertTrue(l.insert(1, 20));
        assertEquals(2, l.size());
        assertEquals(20, l.get(1));

        assertTrue(l.insert(0, 0));
        assertEquals(3, l.size());
        assertEquals(0, l.get(0));
        assertEquals(10, l.get(1));
        assertEquals(20, l.get(2));

        assertTrue(l.insert(l.size(), 100));
        assertEquals(100, l.get(l.size() - 1));
    }

    @Test
    public void testDelete() {
        DoublyLinkedList l = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            assertTrue(l.add(i));
        }
        for (int i = 0; i < l.size(); i++) {
            assertEquals(i, l.get(i));
        }
        l.delete(l.size() - 1);
        for (int i = 0; i < l.size(); i++) {
            assertEquals(i, l.get(i));
        }
        l.delete(0);
        for (int i = 0; i < l.size(); i++) {
            assertEquals(i + 1, l.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBounds1() {
        DoublyLinkedList l = new DoublyLinkedList();
        l.delete(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBounds2() {
        DoublyLinkedList l = new DoublyLinkedList();
        l.add(10);
        l.add(20);
        l.delete(l.size());
    }
}