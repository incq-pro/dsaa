package stack;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class ArrayStackTest {
    @Test
    public void testInit() {
        ArrayStack stack = new ArrayStack(10);
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushPop() {
        ArrayStack stack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            assertTrue(stack.push("" + i));
            assertEquals("" + i, stack.head());
        }
        for (int i = 9; i >= 0; i--) {
            assertEquals("" + i, stack.pop());
        }
        assertNull(stack.pop());
    }
}