package pro.incq.design.dp;

/**
 *
 */
public class RobotCoinCollection {
    public static void main(String[] args) {
        RobotCoinCollection c = new RobotCoinCollection();
        System.out.println(c.robotCoinCollection(new int[][]{{1}}));
        System.out.println(c.robotCoinCollection(new int[][]{{0}}));
        System.out.println(c.robotCoinCollection(new int[][]{{1, 0}}));
        System.out.println(c.robotCoinCollection(new int[][]{{1, 1}, {0, 1}}));
        System.out.println(c.robotCoinCollection(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 1}}));
    }

    public int robotCoinCollection(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[] f = new int[m * n];
        f[0] = coins[0][0];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + coins[0][i];
        }
        for (int i = 1; i < m; i++) {
            f[n * i] = f[n * (i - 1)] + coins[i][0];
            for (int j = 1; j < n; j++) {
                f[i * n + j] = Math.max(f[(i - 1) * n + j], f[i * n + j - 1]) + coins[i][j];
            }
        }
        return f[m * n - 1];
    }
}
