package  pro.incq.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public class RabinKarpMatch implements Match {
    private static final int S = 26;

    @Override
    public int match(char[] a, char[] b) {
        if (!preCheck(a, b)) {
            return -1;
        }
        final int n = a.length;
        final int m = b.length;
        int[] table = new int[m];
        table[m - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            table[i] = table[i + 1] * S;
        }
        int hashb = 0;
        for (int i = 0; i < m; i++) {
            hashb += (b[i] - 'a') * table[i];
        }
        int[] hash = new int[n - m + 1];
        int hasha = 0;
        for (int i = 0; i < m; i++) {
            hasha += (a[i] - 'a') * table[i];
        }
        if (hasha == hashb) {
            return 0;
        }
        hash[0] = hasha;
        for (int i = 1; i < n - m + 1; i++) {
            hasha = (hash[i - 1] - (a[i - 1] - 'a') * table[0]) * S + (a[i + m - 1] - 'a');
            if (hasha == hashb) {
                return i;
            }
            hash[i] = hasha;
        }
        return -1;
    }
}
