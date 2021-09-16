package pro.incq.leetcode.divide;

import pro.incq.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class BuildTreeFromTraversal {
    private int[] t1;
    private int[] t2;

    public TreeNode fromPrePost(int[] pre, int[] post) {
        this.t1 = pre;
        this.t2 = post;
        return fromPrePostConstruct(0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode fromPrePostConstruct(int i, int j, int p, int q) {
        if (i > j) {
            return null;
        } else if (i == j) {
            return new TreeNode(t1[i]);
        }
        System.out.println(t1[i] == t2[q]);
        TreeNode root = new TreeNode(t1[i]);
        // left
        int x = 0;
        while (t2[p + x] != t1[i + 1]) {
            x++;
        }
        root.left = fromPrePostConstruct(i + 1, i + 1 + x, p, p + x);
        // right
        root.right = fromPrePostConstruct(i + 1 + x + 1, j, p + x + 1, q - 1);
        return root;
    }


    public TreeNode fromInAndPost(int[] inorder, int[] postorder) {
        return null;
    }

    public static void main(String[] args) {
        BuildTreeFromTraversal p = new BuildTreeFromTraversal();
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        TreeNode node = p.fromPrePost(pre, post);
    }


}
