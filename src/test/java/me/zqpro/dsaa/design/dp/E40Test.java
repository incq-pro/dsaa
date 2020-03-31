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
                {5},
                {7, 8},
                {2, 3, 4},
                {4, 9, 6, 1},
                {2, 7, 9, 4, 5},
        };
        int x = E40.minPath(nodes, nodes.length);
        System.out.println(x);
//        assertEquals(3, x);
    }
}