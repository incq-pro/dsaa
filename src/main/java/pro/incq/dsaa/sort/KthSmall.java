package pro.incq.dsaa.sort;

/**
 * @author yun.516@gmail.com
 */
public class KthSmall {
    public static int kthSmall(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }

        int q = partition(a, 0, a.length - 1);
        while (q != k - 1) {
            if (q < k - 1) {
                q = partition(a, q + 1, a.length - 1);
            } else {
                q = partition(a, 0, q - 1);
            }
        }
        return a[q];
    }

    private static int partition(int[] a, int p, int r) {
        final int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {
                if (i != j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                ++i;
            }
        }
        a[r] = a[i];
        a[i] = pivot;
        return i;
    }
}
