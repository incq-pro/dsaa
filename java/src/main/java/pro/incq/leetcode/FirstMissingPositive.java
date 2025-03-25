package pro.incq.leetcode;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 输入: [1,2,0] ，输出: 3；输入: [3,4,-1,1] 输出: 2
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }
        int n = nums.length;
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

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int[] nums = {1, 2, 0};
        System.out.println(f.firstMissingPositive(nums));
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(f.firstMissingPositive(nums2));
        int[] nums3 = {1, 1};
        System.out.println(f.firstMissingPositive(nums3));

    }
}
