package pro.incq.dsaa.linear.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class LinkedQueueTest {
    @Test
    public void testInit() {
        LinkedQueue queue = new LinkedQueue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test() {
        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            assertTrue(queue.enqueue("" + i));
        }
        assertEquals(10, queue.size());
        assertFalse(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            assertEquals("" + i, queue.dequeue());
        }

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

}