package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class SortsTest {
    private int[] a;

    @Before
    public void setup() {
        a = new int[]{5, 1, 6, 2, 7, 3, 8, 4, 10, 9};
    }

    @After
    public void tearDown() {
        a = null;
    }

    @Test
    public void bubbleSort() {
        Sorts.bubbleSort(a);
        checkA();
    }

    @Test
    public void bubbleSort2() {
        Sorts.bubbleSort2(a);
        checkA();
    }

    @Test
    public void insertionSort() {
        Sorts.insertionSort(a);
        checkA();
    }

    @Test
    public void selectionSort() {
        Sorts.selectionSort(a);
        checkA();
    }

    @Test
    public void quickSort() {
        Sorts.quickSort(a);
        checkA();
    }

    @Test
    public void mergeSort() {
        Sorts.mergeSort(a);
        checkA();
    }

    private void checkA() {
        for (int i = 0; i < a.length; i++) {
            assertEquals(i + 1, a[i]);
        }
    }
}