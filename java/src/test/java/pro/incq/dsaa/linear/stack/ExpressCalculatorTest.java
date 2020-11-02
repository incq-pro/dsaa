package pro.incq.dsaa.linear.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class ExpressCalculatorTest {

    @Test
    public void calculator() {
        assertEquals(3, ExpressCalculator.calculate("1 + 2"));
        assertEquals(2, ExpressCalculator.calculate("3 - 1"));
        assertEquals(6, ExpressCalculator.calculate("2 * 3"));
        assertEquals(2, ExpressCalculator.calculate("4 / 2"));
        assertEquals(14, ExpressCalculator.calculate("2 + 3 * 4"));
        assertEquals(4, ExpressCalculator.calculate("2 + 4 / 2"));
        assertEquals(13, ExpressCalculator.calculate("2 + 4 * 3 - 1"));
        assertEquals(3, ExpressCalculator.calculate("2 + 4 / 2 - 1"));
        assertEquals(4, ExpressCalculator.calculate("1 + 2 * 3 - 6 / 2"));
    }
}