package pro.incq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> item = Arrays.asList(nums[i], nums[j], nums[k]);
                        boolean found = false;
                        for(List<Integer> x : result) {
                            if (x.equals(item)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            result.add(item);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        int[] nums = {-1, 0, 1, -2, 1, 1};
        System.out.println(s.threeSum(nums));
    }
}
