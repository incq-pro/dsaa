package pro.incq.dsaa.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yun.516@gmail.com
 */
public class RecursiveAlgoTest {

    @Test
    public void stairsStep() {
        assertEquals(1, RecursiveAlgo.stairsStep(1));
        assertEquals(2, RecursiveAlgo.stairsStep(2));
        assertEquals(3, RecursiveAlgo.stairsStep(3));
        assertEquals(5, RecursiveAlgo.stairsStep(4));

    }
    @Test
    public void stairStepLoop() {
        assertEquals(1, RecursiveAlgo.stairStepLoop(1));
        assertEquals(2, RecursiveAlgo.stairStepLoop(2));
        assertEquals(3, RecursiveAlgo.stairStepLoop(3));
        assertEquals(5, RecursiveAlgo.stairStepLoop(4));

    }
}