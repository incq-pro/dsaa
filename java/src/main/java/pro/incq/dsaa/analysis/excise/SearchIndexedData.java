package pro.incq.dsaa.analysis.excise;

public class SearchIndexedData {
    /**
     * a0 < a1 < a2 < ... < an
     * if ai == i for i in 0..n-1 exists, return true, otherwise return false
     */
    public static int find(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > mid) {
                high = mid - 1;
            } else if (a[mid] < mid) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(find(a));
    }
}
