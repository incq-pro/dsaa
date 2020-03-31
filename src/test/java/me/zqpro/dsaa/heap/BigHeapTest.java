package me.zqpro.dsaa.heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class BigHeapTest {
    @Test
    public void test() {
        BigHeap<Integer> b = new BigHeap<>(5);
        for (int i = 0; i < 5; i++) {
            b.add(i);
        }
        assertEquals(Integer.valueOf(4), b.getHead());
    }
}