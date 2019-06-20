package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yun.516@gmail.com
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
//        int[] v = new int[]{0, 1, 1, 2, 2, 2, 3, 3, 3};
//        System.out.println(ts.fistGE(v, 0, v.length - 1, 2));
//        System.out.println(ts.lastLE(v, 0, v.length - 1, 2));
        System.out.println(ts.threeSum2(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0, 1, 1, 1}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return ret;
        }

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r && nums[r] >= 0) {
                int a;
                int b;
                if (nums[l] < 0) {
                    a = nums[i];
                    b = -(nums[r] + nums[l]);
                } else {
                    a = (nums[i] + nums[l]);
                    b = -nums[r];
                }
                if (a > b) {
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;
                } else if (a < b) {
                    while (l < r && nums[l + 1] == nums[l]) {
                        ++l;
                    }
                    l++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r - 1] == nums[r]) {
                        --r;
                    }
                    --r;
                    while (l < r && nums[l + 1] == nums[l]) {
                        ++l;
                    }
                    ++l;
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return ret;
        }

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;

            int k = 0;
            long numsi = nums[i];
            while (l < r && nums[r] >= 0) {
                long v;
                if ((k++ & 0x1) == 0) {
                    v = 0L - ((long) nums[l] + numsi);
                    if (v > Integer.MAX_VALUE) {
                        continue;
                    }
                    int lastR = lastLE(nums, l + 1, r, (int) v);
                    if (lastR == -1) {
                        break;
                    }
                    if (nums[lastR] == v) {
                        ret.add(Arrays.asList(nums[i], nums[l], nums[lastR]));
                        while (l < lastR && nums[lastR - 1] == nums[lastR]) {
                            lastR--;
                        }
                        r = --lastR;
                    } else {
                        r = lastR;
                    }
                } else {
                    v = 0L - ((long) nums[r] + numsi);
                    int firstL = fistGE(nums, l, r - 1, (int) v);
                    if (firstL == -1) {
                        break;
                    }

                    if (nums[firstL] == v) {
                        ret.add(Arrays.asList(nums[i], nums[firstL], nums[r]));
                        while (firstL < r && nums[firstL + 1] == nums[firstL]) {
                            ++firstL;
                        }
                        l = ++firstL;
                    } else {
                        l = firstL;
                    }

                }
            }
        }
        return ret;
    }

    // last less or equal to v
    private int lastLE(int[] nums, int p, int r, int v) {
        int p1 = p;
        int r1 = r;
        while (p1 <= r1) {
            int m = p1 + (r1 - p1) / 2;
            if (nums[m] > v) {
                r1 = m - 1;
            } else {
                if (m == r || nums[m + 1] > v) {
                    return m;
                }
                p1 = m + 1;
            }
        }
        return -1;
    }


    private int fistGE(int[] nums, int p, int r, int v) {
        int p1 = p;
        int r1 = r;
        while (p1 <= r1) {
            int m = p1 + (r1 - p1) / 2;
            if (nums[m] < v) {
                p1 = m + 1;
            } else {
                if (m == p || nums[m - 1] < v) {
                    return m;
                }
                r1 = m - 1;
            }
        }
        return -1;
    }
}
