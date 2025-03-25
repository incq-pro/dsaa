package  pro.incq.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public class BruteForceMatch implements Match {
    @Override
    public int match(char[] a, char[] b) {
        if (!preCheck(a, b)) {
            return -1;
        }
        final int n = a.length;
        final int m = b.length;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
