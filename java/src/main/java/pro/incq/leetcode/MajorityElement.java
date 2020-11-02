package pro.incq.leetcode;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    num = nums[i];
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {3, 2, 1, 3, 3};
        System.out.println(me.majorityElement(nums));
    }
}
