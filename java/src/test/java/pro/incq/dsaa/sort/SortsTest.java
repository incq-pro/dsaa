package pro.incq.dsaa.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Sorts.bubbleSort(b);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, b[i]);
            assertEquals((i + 1) * 10, b[i + 10]);
        }
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