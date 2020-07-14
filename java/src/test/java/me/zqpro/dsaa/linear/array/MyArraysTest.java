package me.zqpro.dsaa.linear.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class MyArraysTest {
    @Test
    public void merge() {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {0, 2, 4, 6, 8};
        int[] c = MyArrays.merge(a, b);
        assertEquals(a.length + b.length, c.length);
        for (int i = 0; i < c.length; i++) {
            assertEquals(i, c[i]);
        }
    }
}