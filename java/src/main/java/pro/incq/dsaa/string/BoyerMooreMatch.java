package  pro.incq.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public class BoyerMooreMatch implements Match {
    private static final int SIZE = 256;


    @Override
    public int match(char[] a, char[] b) {
        if (!preCheck(a, b)) {
            return -1;
        }
        final int n = a.length;
        final int m = b.length;
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            for (; j >= 0; j--) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            int x = j - bc[(int) a[i + j]];
            int y = moveByGS(j, m, suffix, prefix);
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * @param j      the bad char index
     * @param m      the b length
     * @param suffix
     * @param prefix
     * @return move steps
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r <= m - 1; r++) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }

    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int k = 0;
            int j = i;
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                suffix[++k] = j--;
            }
            if (j < 0) {
                prefix[k] = true;
            }
        }
    }
}
