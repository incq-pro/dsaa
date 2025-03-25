package pro.incq.design.divide_conquer;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }
}
