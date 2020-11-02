package pro.incq.dsaa.heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class IntHeapTest {
    @Test
    public void testHeap() {
        final int n = 5;
        IntHeap p = new IntHeap(n);
        for (int i = 0; i < n; i++) {
            assertTrue(p.add(i));
        }

        for (int i = n - 1; i >= 0; i--) {
            assertEquals(i, p.popHead());
        }
    }

    @Test
    public void sort() {
        int[] a = {6, 7, 5, 8, 4, 9, 2, 1};
        IntHeap.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] < a[i + 1]);
        }
    }
}