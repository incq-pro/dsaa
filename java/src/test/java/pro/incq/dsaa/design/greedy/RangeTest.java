package pro.incq.dsaa.design.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yun.516@gmail.com
 */
public class RangeTest {

    @Test
    public void max() {
        int[][] ranges = {
                {6, 8},
                {2, 4},
                {3, 5},
                {1, 5},
                {5, 9},
                {8, 10},
        };
        for (int[] x : Range.max(ranges)) {
            if (x != null) {
                System.out.println(Arrays.toString(x));
            }
        }
    }
}