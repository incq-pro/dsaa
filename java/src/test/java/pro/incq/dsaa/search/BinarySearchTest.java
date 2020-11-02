package pro.incq.dsaa.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class BinarySearchTest {

    private int[] a;

    @Before
    public void setUp() {
        a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 2;
        }
    }

    @Test
    public void bsearch() {
        assertEquals(0, BinarySearch.bsearch(a, 0));
        assertEquals(1, BinarySearch.bsearch(a, 2));
        assertEquals(99, BinarySearch.bsearch(a, 198));
        assertEquals(-1, BinarySearch.bsearch(a, 1));
        assertEquals(-1, BinarySearch.bsearch(a, 3));
        assertEquals(-1, BinarySearch.bsearch(a, 197));
        assertEquals(-1, BinarySearch.bsearch(a, 199));
    }

    @Test
    public void bsearch2() {
        assertEquals(0, BinarySearch.bsearch2(a, 0));
        assertEquals(1, BinarySearch.bsearch2(a, 2));
        assertEquals(99, BinarySearch.bsearch2(a, 198));
        assertEquals(-1, BinarySearch.bsearch2(a, 1));
        assertEquals(-1, BinarySearch.bsearch2(a, 3));
        assertEquals(-1, BinarySearch.bsearch2(a, 197));
        assertEquals(-1, BinarySearch.bsearch2(a, 199));
    }

    @Test
    public void sqrt() {
        System.out.println(BinarySearch.sqrt(4.1));
        System.out.println(Math.sqrt(4.1));
    }

    @Test
    public void firstEqual() {
        int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        assertEquals(0, BinarySearch.firstEqual(a, 1));
        assertEquals(3, BinarySearch.firstEqual(a, 2));
        assertEquals(6, BinarySearch.firstEqual(a, 3));
        assertEquals(9, BinarySearch.firstEqual(a, 4));
        assertEquals(-1, BinarySearch.firstEqual(a, 5));
    }


    @Test
    public void lastEqual() {
        int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        assertEquals(2, BinarySearch.lastEqual(a, 1));
        assertEquals(5, BinarySearch.lastEqual(a, 2));
        assertEquals(8, BinarySearch.lastEqual(a, 3));
        assertEquals(11, BinarySearch.lastEqual(a, 4));
        assertEquals(-1, BinarySearch.lastEqual(a, 5));
    }

    @Test
    public void firstGreaterEqual() {
        int[] a = {1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7};
        assertEquals(0, BinarySearch.firstGreaterEqual(a, 1));
        assertEquals(3, BinarySearch.firstGreaterEqual(a, 2));
        assertEquals(3, BinarySearch.firstGreaterEqual(a, 3));
        assertEquals(6, BinarySearch.firstGreaterEqual(a, 4));
        assertEquals(9, BinarySearch.firstGreaterEqual(a, 6));
        assertEquals(9, BinarySearch.firstGreaterEqual(a, 7));
        assertEquals(-1, BinarySearch.firstGreaterEqual(a, 8));
    }


    @Test
    public void lastLessEqual() {
        int[] a = {1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7};
        assertEquals(2, BinarySearch.lastLessEqual(a, 1));
        assertEquals(2, BinarySearch.lastLessEqual(a, 2));
        assertEquals(5, BinarySearch.lastLessEqual(a, 3));
        assertEquals(5, BinarySearch.lastLessEqual(a, 4));
        assertEquals(8, BinarySearch.lastLessEqual(a, 6));
        assertEquals(11, BinarySearch.lastLessEqual(a, 7));
        assertEquals(11, BinarySearch.lastLessEqual(a, 8));
        assertEquals(11, BinarySearch.lastLessEqual(a, 100));
        assertEquals(-1, BinarySearch.lastLessEqual(a, 0));
    }

    @Test
    public void bsearchLoopArray() {
        int[] a = {4, 5, 6, 1, 2, 3};
        assertEquals(3, BinarySearch.bsearchLoopArray(a, 1));
        assertEquals(4, BinarySearch.bsearchLoopArray(a, 2));
        assertEquals(5, BinarySearch.bsearchLoopArray(a, 3));
        assertEquals(0, BinarySearch.bsearchLoopArray(a, 4));
        assertEquals(1, BinarySearch.bsearchLoopArray(a, 5));
        assertEquals(2, BinarySearch.bsearchLoopArray(a, 6));
        assertEquals(-1, BinarySearch.bsearchLoopArray(a, 0));
        assertEquals(-1, BinarySearch.bsearchLoopArray(a, 7));
        assertEquals(-1, BinarySearch.bsearchLoopArray(a, Integer.MAX_VALUE));
    }
}