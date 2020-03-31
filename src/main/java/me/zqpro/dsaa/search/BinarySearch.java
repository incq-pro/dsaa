package search;

/**
 * @author yun.516@gmail.com
 */
public class BinarySearch {
    public static int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bsearch2(int[] a, int value) {
        return bsearchRecursive(a, 0, a.length - 1, value);
    }

    private static int bsearchRecursive(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        int v = a[mid];
        if (v > value) {
            return bsearchRecursive(a, low, mid - 1, value);
        } else if (v < value) {
            return bsearchRecursive(a, mid + 1, high, value);
        } else {
            return mid;
        }
    }

    public static double sqrt(double n) {
        final double step = 0.000001;
        double low = 0.0;
        double high = n;
        double mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2.0;
            double mid2 = mid + step;
            double mid3 = mid * mid;
            double mid4 = mid2 * mid2;
            if (mid3 < n) {
                if (mid4 >= n) {
                    break;
                }
                low = mid + step;
            } else if (mid3 > n) {
                high = mid - step;
            } else {
                return mid;
            }
        }
        if ((n - mid * mid) < ((mid + step) * (mid + step) - n)) {
            return mid;
        }
        return mid + step;
    }

    public static int firstEqual(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int lastEqual(int[] a, int value) {
        final int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int firstGreaterEqual(int[] a, int value) {
        final int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int lastLessEqual(int[] a, int value) {
        final int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bsearchLoopArray2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        final int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                if (nums[mid] >= nums[0]) {
                    if (target >= nums[0]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (nums[mid] <= nums[n - 1]) {
                    if (target <= nums[n - 1]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bsearchLoopArray(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        final int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target) {
                    if (target >= nums[0]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] < target) {
                    if (target <= nums[n-1]) {
                        low = mid + 1;
                    } else {
                        high = mid -1;
                    }
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
