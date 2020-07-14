package me.zqpro.dsaa.design.dp;

/**
 * @author yun.516@gmail.com
 */
public class Pack01 {
    /**
     * @param weight items weight
     * @param n      items count
     * @param w      pack weight
     * @return max pack
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] state = new boolean[n][w + 1];
        state[0][0] = true;
        if (weight[0] <= w) {
            state[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            // i not in
            for (int j = 0; j <= w; j++) {
                if (state[i - 1][j]) {
                    state[i][j] = true;
                }
            }
            // i in
            for (int j = 0; j <= w - weight[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (state[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public static int knapsack2(int[] weight, int n, int w) {
        boolean[] state = new boolean[w + 1];
        state[0] = true;
        if (weight[0] <= w) {
            state[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            // i in
            for (int j = w - weight[i]; j >= 0; j--) {
                if (state[j]) {
                    state[j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (state[i]) {
                return i;
            }
        }
        return 0;
    }

    public static int knapsackV(int[] weight, int[] value, int n, int w) {
        int[][] state = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                state[i][j] = -1;
            }
        }
        state[0][0] = 0;
        if (weight[0] <= w) {
            state[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
            // i not in
            for (int j = 0; j <= w; j++) {
                if (state[i - 1][j] >= 0) {
                    state[i][j] = state[i - 1][j];
                }
            }
            // i in
            for (int j = 0; j <= w - weight[i]; j++) {
                if (state[i - 1][j] >= 0) {
                    int v = state[i - 1][j] + value[i];
                    if (v > state[i][j + weight[i]]) {
                        state[i][j + weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int i = w; i >= 0; i--) {
            if (state[n - 1][i] > maxValue) {
                maxValue = state[n - i][i];
            }
        }
        return maxValue;
    }

    public static int knapsackV2(int[] weight, int[] value, int n, int w) {
        int[] state = new int[w + 1];
        for (int i = 0; i < w + 1; i++) {
            state[i] = -1;
        }
        state[0] = 0;
        if (weight[0] <= w) {
            state[weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            // i in
            for (int j = w - weight[i]; j >= 0; j--) {
                if (state[j] >= 0) {
                    int v = state[j] + value[i];
                    if (v > state[j + weight[i]]) {
                        state[j + weight[i]] = j;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int i = w; i >= 0; i--) {
            if (state[i] > maxValue) {
                maxValue = state[i];
            }
        }
        return maxValue;
    }
}
