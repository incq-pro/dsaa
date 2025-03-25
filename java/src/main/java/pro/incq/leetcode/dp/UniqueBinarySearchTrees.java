package pro.incq.leetcode.dp;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        for (int i = 1; i <= 19; i++) {
            System.out.println(i);
            System.out.println(s.numTrees(i));
        }
    }

    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += f[j - 1] * f[i - j];
            }
            f[i] = sum;
        }
        return f[n];
    }

    public int numTrees2(int n) {
        return doNum(1, n);
    }

    private int doNum(int left, int right) {
        if (left >= right) {
            return 1;
        }
        int total = 0;
        for (int i = left; i <= right; i++) {
            int l = doNum(left, i - 1);
            int r = doNum(i + 1, right);
            total += l * r;
        }
        return total;
    }
}
