package pro.incq.leetcode.dp;


public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString s = new InterleavingString();
        System.out.println(s.isInterleave("a", "ab", "aba"));
        System.out.println(s.isInterleave("aa", "aa", "aaaa"));
        System.out.println(s.isInterleave("a", "b", "ab"));
        System.out.println(s.isInterleave("ab", "ab", "aabb"));
        System.out.println(s.isInterleave("abc", "def", "adbecf"));
        System.out.println(s.isInterleave("a", "ab", "aba"));
        System.out.println(s.isInterleave("a", "ab", "aba"));
    }

    public boolean isInterleaveV2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return isOk(0, 0, 0, s1, s2, s3);
    }

    private boolean isOk(int k, int i, int j, String s1, String s2, String s3) {
        if (k >= s3.length()) {
            return true;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (isOk(k + 1, i + 1, j, s1, s2, s3)) {
                return true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (isOk(k + 1, i, j + 1, s1, s2, s3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int n = s3.length();
        int m = s1.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char c3 = s3.charAt(i - 1);
            boolean pass = false;
            int minK = Math.min(i, m + 1);
            for (int k = 0; k < minK; k++) {
                if (f[i - 1][k]) {
                    if (k < m && s1.charAt(k) == c3) {
                        f[i][k + 1] = true;
                        pass = true;
                    }
                    if ((i - k) <= s2.length() && s2.charAt(i - k - 1) == c3) {
                        f[i][k] = true;
                        pass = true;
                    }
                }
            }
            if (!pass) {
                return false;
            }
        }
        return true;
    }
}


