package me.zqpro.dsaa.linear.array;

/**
 * @author yun.516@gmail.com
 */
public class LeetCodeSolution {
    /**
     * https://leetcode-cn.com/problems/first-missing-positive/submissions/
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (v > 0 && v <= n && nums[v - 1] != v) {
                nums[i] = nums[v - 1];
                nums[v - 1] = v;
                v = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
