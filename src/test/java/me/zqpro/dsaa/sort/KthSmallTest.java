package sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class KthSmallTest {

    @Test
    public void kthSmall() {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(1, KthSmall.kthSmall(a, 1));
        assertEquals(2, KthSmall.kthSmall(a, 2));
        assertEquals(3, KthSmall.kthSmall(a, 3));
        assertEquals(9, KthSmall.kthSmall(a, 9));
    }
}