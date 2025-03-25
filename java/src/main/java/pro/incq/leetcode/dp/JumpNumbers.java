package pro.incq.leetcode.dp;

public class JumpNumbers {
    public static void main(String[] args) {
        JumpNumbers j = new JumpNumbers();
//        System.out.println(j.canJum(new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 5}));
//        System.out.println(j.canJum(new int[]{1}));
//        System.out.println(j.minJum(new int[]{1}));
        System.out.println(j.minJum(new int[]{3, 1, 1}));
        System.out.println(j.minJum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public boolean canJum(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i <= max; i++) {
            if (i + nums[i] > max) {
                max = i + nums[i];
                if (max >= n - 1) {
                    return true;
                }
            }
        }
        return max >= n - 1;
    }

    public int minJum(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            int m = Math.min(n, i + nums[i] + 1);
            for (int j = i + 1; j < m; j++) {
                if (f[j] <= 0) {
                    f[j] = f[i] + 1;
                } else {
                    f[j] = Math.min(f[j], f[i] + 1);
                }
            }
        }
        return f[n - 1];
    }
}
