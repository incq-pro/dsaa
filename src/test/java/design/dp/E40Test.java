package design.dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class E40Test {

    @Test
    public void minPath() {
        int[][] nodes = {
                {1},
                {1,2},
                {1,2,3}
        };
        int x = E40.minPath(nodes, nodes.length);
        assertEquals(3, x);
    }
}