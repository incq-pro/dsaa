package pro.incq.leetcode;

public class SearchMatrix {


    private int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        return search(0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    private boolean search(int top, int left, int bottom, int right, int target) {
        if (top > bottom || left > right) {
            return false;
        }
        if (target < matrix[top][left] || target > matrix[bottom][right]) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int row = top;
        while (row <= bottom && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return search(row, left, bottom, mid - 1, target) || search(top, mid + 1, row - 1, right, target);
    }
}
