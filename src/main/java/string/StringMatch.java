package string;

/**
 * @author yun.516@gmail.com
 */
public class StringMatch {
    public static int bf(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int n = ac.length;
        int m = bc.length;
        if (m > n) {
            return -1;
        }
        for (int i = 0; i <= n - m; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (ac[i + j] == bc[j]) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == m) {
                return i;
            }
        }
        return -1;
    }

    public static int nk(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int n = a1.length;
        int m = b1.length;
        if (m > n) {
            return -1;
        }

        int[] table = new int[m];
        int sum = 1;
        for (int i = 0; i < m; i++) {
            table[i] = sum;
            sum *= 26;
        }
        int bs = 0;
        for (int i = 0; i < m; i++) {
            bs += (b1[i] - 'a') * table[m - 1 - i];
        }
        int[] hash = new int[n - m + 1];
        int s = 0;
        for (int i = 0; i < m; i++) {
            s += (a1[i] - 'a') * table[m - 1 - i];
        }
        hash[0] = s;
        if (hash[0] == bs) {
            return 0;
        }
        for (int i = 1; i <= n - m; i++) {
            hash[i] = (hash[i - 1] - (a1[i - 1] - 'a') * table[m - 1]) * 26 + (a1[i + m - 1] - 'a');
            if (hash[i] == bs) {
                return i;
            }
        }
        return -1;
    }

    public static int bm(String astr, String bstr) {
        final char[] a = astr.toCharArray();
        final char[] b = bstr.toCharArray();
        final int n = a.length;
        final int m = b.length;
        if (m > n) {
            return -1;
        }
        int[] bc = generateBC(b, m);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);

        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            int x = (j - bc[(int) a[i + j]]);
            int y = 0;
            if (j < m - 1) {
                y = moveByGS(i, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    private static final int BC_SIZE = 256;

    private static int[] generateBC(char[] b, int m) {
        int[] bc = new int[BC_SIZE];
        for (int i = 0; i < BC_SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            bc[(int) b[i]] = i;
        }
        return bc;
    }

    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && b[j] == b[m - 1 - j]) {
                suffix[++k] = j--;
            }
            if (j < 0) {
                prefix[k] = true;
            }
        }
    }

    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j + 1 - suffix[k];
        }
        for (int r = j + 2; r <= m - 1; r++) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }

    public static int kmp(String astr, String bstr) {
        char[] a = astr.toCharArray();
        char[] b = bstr.toCharArray();
        int n = a.length;
        int m = b.length;
        if (m > n) {
            return -1;
        }
        int[] next = getKmpNexts(b, m);
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

    private static int[] getKmpNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k >= 0 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
