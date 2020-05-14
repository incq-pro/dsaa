package me.zqpro.dsaa.design.greedy;

import java.util.Arrays;

/**
 * @author yun.516@gmail.com
 */
public class Bag {
    /**
     * @param capacity
     * @param beans    [[100, 100], [30, 90], [60, 120]]
     * @return max value
     */
    public static double maxValue(int capacity, int[][] beans) {
        Arrays.sort(beans, (a, b) -> {
            double pa = (double) a[1] / a[0];
            double pb = (double) b[1] / b[0];
            if (pa > pb) {
                return -1;
            } else if (pa < pb) {
                return 1;
            } else {
                return 0;
            }
        });
        double value = 0.0;
        int c = capacity;
        for (int i = 0; i < beans.length && c > 0; i++) {
            int taken = Math.min(c, beans[i][0]);
            value += taken * beans[i][1] / (double)beans[i][0];
            c -= taken;
        }
        return value;
    }
}
