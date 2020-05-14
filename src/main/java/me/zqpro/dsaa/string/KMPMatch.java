package  me.zqpro.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public class KMPMatch implements Match {
    @Override
    public int match(char[] a, char[] b) {
        if (!preCheck(a, b)) {
            return -1;
        }
        final int n = a.length;
        final int m = b.length;

        int[] next = new int[m];
        getNexts(b, m, next);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private void getNexts(char[] b, int m, int[] next) {
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k >= 0 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                k += 1;
            }
            next[i] = k;
        }
    }
}
