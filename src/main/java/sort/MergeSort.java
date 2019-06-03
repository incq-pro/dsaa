package sort;

/**
 * @author yun.516@gmail.com
 */
public class MergeSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int p, int q) {
        if (p >= q) {
            return;
        }
        int middle = (p + q) / 2;
        sort(a, p, middle);
        sort(a, middle + 1, q);
        merge(a, p, middle, q);
    }

    private void merge(int[] a, int p, int middle, int q) {
        int[] tmp = new int[q - p + 1];
        int i = p;
        int j = middle + 1;
        int tmpi = 0;
        while (i <= middle && j <= q) {
            if (a[i] <= a[j]) {
                tmp[tmpi++] = a[i++];
            } else {
                tmp[tmpi++] = a[j++];
            }
        }
        if (i <= middle) {
            for (; i <= middle; i++) {
                tmp[tmpi++] = a[i];
            }
        }
        if (j <= q) {
            for (; j <= q; j++) {
                tmp[tmpi++] = a[j];
            }
        }
        System.arraycopy(tmp, 0, a, p, tmp.length);
    }
}
