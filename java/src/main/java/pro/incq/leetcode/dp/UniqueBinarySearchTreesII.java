package pro.incq.leetcode.dp;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    @ToString
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII x = new UniqueBinarySearchTreesII();
        for(int i = 1; i < 8; i++) {
            System.out.println(x.generateTrees(i));
        }
    }

    @SuppressWarnings("unchecked")
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> nulls = new ArrayList<>(1);
        nulls.add(null);
        Object[][] f = new Object[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                List<TreeNode> xx = new ArrayList<>();
                for (int k = j; k <= i+j; k++) {
                    List<TreeNode> lefts = nulls;
                    if (k - 1 >= j) {
                        lefts = (List<TreeNode>)f[j][k-1];
                    }
                    List<TreeNode> rights = nulls;
                    if (k + 1 <= j+i) {
                        rights = (List<TreeNode>)f[k+1][j+i];
                    }

                    for (TreeNode left : lefts) {
                        for (TreeNode right : rights) {
                            TreeNode r = new TreeNode(k);
                            r.left = left;
                            r.right = right;
                            xx.add(r);
                        }
                    }
                }
                f[j][j+i] = xx;
            }
        }
        return (List<TreeNode>) (f[1][n]);
    }
}



