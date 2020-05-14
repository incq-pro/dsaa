package me.zqpro.dsaa.sort;

/**
 * @author yun.516@gmail.com
 */
public class Sorts {
    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            boolean swapFlag = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }

    public static void bubbleSort2(int[] a) {
        final int n = a.length;
        int lastChange = 0;
        for (int i = n - 1; i > 0; ) {
            boolean swapFlag = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapFlag = true;
                    lastChange = j;
                }
            }
            if (!swapFlag) {
                break;
            }
            i = lastChange;
        }
    }

    public static void insertionSort(int[] a) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmp < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = tmp;
        }
    }

    public static void selectionSort(int[] a) {
        final int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void mergeSort(int[] a) {
        doMergeSort(a, 0, a.length - 1);
    }

    private static void doMergeSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        doMergeSort(a, p, q);
        doMergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        if (i <= q) {
            for (; i <= q; i++) {
                tmp[k++] = a[i];
            }
        } else {
            for (; j <= r; j++) {
                tmp[k++] = a[j];
            }
        }
        System.arraycopy(tmp, 0, a, p, r - p + 1);
    }

    public static void quickSort(int[] a) {
        doQuickSort(a, 0, a.length - 1);
    }

    private static void doQuickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        doQuickSort(a, p, q - 1);
        doQuickSort(a, q + 1, r);
    }

    private static int partition(int[] a, final int p, final int r) {
        final int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i != j) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
                ++i;
            }
        }
        a[r] = a[i];
        a[i] = pivot;

        return i;
    }

    public static void countingSort(int[] a, int max) {

    }
}
