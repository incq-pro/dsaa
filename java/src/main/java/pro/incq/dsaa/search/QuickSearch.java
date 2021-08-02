package pro.incq.dsaa.search;

/**
 * 快速查找第k小元素
 *
 * @author pro.incq
 * @date 2021-04-13
 */
public class QuickSearch {
    public int findKth(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int s = partition(nums, left, right);
            if (s == k - 1) {
                return nums[s];
            } else if (s < k - 1) {
                left = s + 1;
            } else if (s > k - 1) {
                right = s - 1;
            }
        }
        throw new IllegalArgumentException("k is out of range!!");
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int s = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                s++;
                swap(nums, s, i);
            }
        }
        swap(nums, l, s);
        return s;
    }

    private void swap(int[] nums, int i, int j) {
        if ( i== j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {18, 8, 4, 16, 6, -1, 7, 5, 3};

        QuickSearch qs = new QuickSearch();
        for (int i = 0; i < nums.length + 1; i++) {
            System.out.println(qs.findKth(nums, i + 1));
        }
    }
}
