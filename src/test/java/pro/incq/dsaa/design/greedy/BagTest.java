package pro.incq.dsaa.design.greedy;

import org.junit.Test;

/**
 * @author yun.516@gmail.com
 */
public class BagTest {

    @Test
    public void maxValue() {
        int capacity = 100;
        int[][] beans = {
                {100, 100},
                {30, 90},
                {60, 120},
                {20, 80},
                {50, 75}
        };
        double value = Bag.maxValue(capacity, beans);
        System.out.println(value);
    }
}