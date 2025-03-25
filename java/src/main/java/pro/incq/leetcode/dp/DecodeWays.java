package pro.incq.leetcode.dp;

public class DecodeWays {
    public int numDecodings(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] f = new int[n];
        // f0
        if (a[0] >= '1' && a[0] <= '9') {
            f[0] = 1;
        } else {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] >= '1' && a[i] <= '9') {
                f[i] = f[i - 1];
            }
            if ((a[i - 1] == '1' && a[i] >= '0' && a[i] <= '9') || (a[i - 1] == '2' && a[i] >= '0' && a[i] <= '6')) {
                f[i] += i > 1 ? f[i - 2] : 1;
            }
            if (f[i] == 0) {
                return 0;
            }
        }
        return f[n - 1];
    }

}
