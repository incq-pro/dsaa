package design.dp;

/**
 * @author yun.516@gmail.com
 */
public class E40 {
    /**
     * @param nodes [[1], [1, 2], [1,2,3]...[1...n+1]]
     * @param n
     * @return
     */
    public static int minPath(int[][] nodes, int n) {
        int[][] nodes2 = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] x = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                x[j] = Integer.MAX_VALUE;
            }
            nodes2[i] = x;
        }
        nodes2[0][0] = nodes[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j - 1 >= 0) {
                    int v = nodes2[i - 1][j - 1] + nodes[i][j];
                    if (v < nodes2[i][j]) {
                        nodes2[i][j] = v;
                    }
                }
                if (j < i) {
                    int v = nodes2[i - 1][j] + nodes[i][j];
                    if (v < nodes2[i][j]) {
                        nodes2[i][j] = v;
                    }
                }
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nodes2[n - 1][i] < minValue) {
                minValue = nodes2[n - 1][i];
            }
        }
        return minValue;
    }
}
