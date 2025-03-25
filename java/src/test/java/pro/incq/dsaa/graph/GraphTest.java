package pro.incq.dsaa.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yun.516@gmail.com
 */
public class GraphTest {

    private Graph g;

    @Before
    public void setUp() {
        if (g == null) {
            g = new Graph(8);
            g.addEdge(0, 1);
            g.addEdge(0, 3);
            g.addEdge(1, 2);
            g.addEdge(1, 4);
            g.addEdge(2, 5);
            g.addEdge(3, 4);
            g.addEdge(4, 5);
            g.addEdge(4, 6);
            g.addEdge(5, 7);
            g.addEdge(6, 7);
        }
    }

    @Test
    public void testBfs() {
        g.bfs(0, 0);
        g.bfs(0, 6);
    }

    @Test
    public void testDfs() {
        System.out.println();
        g.dfs(0, 6);
    }

}