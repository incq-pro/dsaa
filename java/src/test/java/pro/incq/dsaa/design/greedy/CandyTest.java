package pro.incq.dsaa.design.greedy;

import org.junit.Test;
import pro.incq.design.greedy.Candy;

/**
 * @author yun.516@gmail.com
 */
public class CandyTest {

    @Test
    public void maxBaby() {
        int[] baby = {11, 12, 13, 14, 15, 26, 27};
        int[] candy = {1, 5, 11, 13, 15, 27, 28};
        int count = Candy.maxBaby(baby, candy);
        System.out.println(count);
    }
}