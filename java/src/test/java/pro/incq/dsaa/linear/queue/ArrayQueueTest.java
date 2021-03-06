package pro.incq.dsaa.linear.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class ArrayQueueTest {
    @Test
    public void testInit() {
        ArrayQueue queue = new ArrayQueue(10);
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test() {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            assertTrue(queue.enqueue("" + i));
        }
        assertFalse(queue.enqueue("x"));
        assertEquals(10, queue.size());
        assertFalse(queue.isEmpty());

        for (int i = 0; i <10; i++) {
            assertEquals("" + i, queue.dequeue());
        }

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

}