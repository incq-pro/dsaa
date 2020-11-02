package pro.incq.dsaa.tree.binarytree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExpressTreeTest {

    @Test
    public void testExpressSuffix() {
        ExpressTree et = new ExpressTree();
        final String expSuffix = "a b + c d e + * *";
        assertTrue(et.parseSuffix(expSuffix));
        assertEquals(
                String.join(",", expSuffix.split(" ")),
                String.join(",", et.printSuffix().trim().split(" ")));
    }
}