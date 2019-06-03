package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class MergeSortTest {

    @Test
    public void sort() {
        int[] a = new int[]{5, 6, 4, 7, 3, 8, 2, 9, 1, 10, 0};
        System.out.println(Arrays.toString(a));
        MergeSort ms = new MergeSort();
        ms.sort(a);
        System.out.println(Arrays.toString(a));
    }
}