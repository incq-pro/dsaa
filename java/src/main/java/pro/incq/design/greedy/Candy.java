package pro.incq.design.greedy;

import java.util.Arrays;

/**
 * @author yun.516@gmail.com
 */
public class Candy {
    public static int maxBaby(int[] baby, int[] candy) {
        Arrays.sort(baby);
        Arrays.sort(candy);
        int i = 0;
        int j = 0;
        while (i < baby.length && j < candy.length) {
            while (j < candy.length) {
                if (candy[j] >= baby[i]) {
                    j++;
                    i++;
                    break;
                }
                j++;
            }
        }
        return i;
    }
}
