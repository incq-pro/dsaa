package pro.incq.leetcode.dp;


public class MaxSubstring {
    public static void main(String[] args) {
        MaxSubstring s = new MaxSubstring();
        System.out.println(s.maxLength("a"));
        System.out.println(s.maxLength("ab"));
        System.out.println(s.maxLength("aba"));
        System.out.println(s.maxLength("abba"));
    }

    public int maxLengthv1(byte[] str) {
        int n = str.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int m = i - 1;
            int k = i + 1;
            for (; m >= 0 && k < n && str[m] == str[k]; m--, k++) {
            }
            int l = k - m - 1;
            if (l > max) {
                max = l;
            }

            m = i;
            k = i + 1;
            for (; m >= 0 && k < n && str[m] == str[k]; m--, k++) {
            }
            l = k - m - 1;
            if (l > max) {
                max = l;
            }
        }
        return max;
    }


    public String maxLength(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = 2;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1] > 0) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = 0;
                }
            }
        }
        int max = 0;
        int maxI = -1;
        int maxJ = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (f[i][j] > max) {
                    max = f[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }


}
