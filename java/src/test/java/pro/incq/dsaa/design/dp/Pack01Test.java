package pro.incq.dsaa.design.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class Pack01Test {

    @Test
    public void knapsack() {
        int[] weight = {2, 2, 4, 6, 3};
        int w = 9;
        int x = Pack01.knapsack(weight, w);
        assertEquals(9, x);

        weight = new int[]{5, 6, 7, 8, 9};
        w = 4;
        x = Pack01.knapsack(weight, w);
        assertEquals(0, x);

        weight = new int[]{1, 1, 4, 4, 5};
        w = 2;
        x = Pack01.knapsack(weight, w);
        assertEquals(2, x);

    }

    @Test
    public void knapsack2() {
        int[] weight = {2, 2, 4, 6, 3};
        int w = 9;
        int x = Pack01.knapsack2(weight, w);
        assertEquals(9, x);

        weight = new int[]{5, 6, 7, 8, 9};
        w = 4;
        x = Pack01.knapsack2(weight, w);
        assertEquals(0, x);

        weight = new int[]{1, 1, 4, 4, 5};
        w = 2;
        x = Pack01.knapsack2(weight, w);
        assertEquals(2, x);

    }
}