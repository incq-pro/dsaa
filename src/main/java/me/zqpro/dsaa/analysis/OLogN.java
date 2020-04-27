package me.zqpro.dsaa.analysis;

/**
 * O(logN)
 */
public class OLogN {
    private static final int NOT_FOUND = -1;

    /**
     * 二分查找
     */
    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                high = mid - 1;
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 最大公约数
     */
    public static long gcd(long m, long n) {
        while (n != 0) {
            long remain = m % n;
            m = n;
            n = remain;
        }
        return m;
    }

    public static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if ((n & 0x1) == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(a, 0));
        System.out.println(binarySearch(a, 1));
        System.out.println(binarySearch(a, 3));
        System.out.println(binarySearch(a, 9));

        System.out.println(gcd(1989, 1590));

        System.out.println(pow(2, 5));
    }
}
