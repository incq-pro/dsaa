package me.zqpro.dsaa.linear.array;

/**
 * @author yun.516@gmail.com
 */
public class MyArrays {
    public static int[] merge(int[] a, int[] b) {
        final int m = a.length;
        final int n = b.length;

        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < m) {
            c[k++] = a[i++];
        }
        while (j < n) {
            c[k++] = b[j++];
        }
        return c;
    }
}
