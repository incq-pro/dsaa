package tree;

/**
 * @author yun.516@gmail.com
 */
public class BinarySearchTree {
    private Node root;

    public Node find(int data) {
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }


    public void insert(int data) {
        if (root == null) {
            root = new Node(data, null, null);
            return;
        }
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data, null, null);
                    return;
                }
                p = p.right;
            } else if (data < p.data) {
                if (p.left == null) {
                    p.left = new Node(data, null, null);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = root;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // not found
        if (p == null) {
            return;
        }
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }
        Node child = p.left;
        if (child == null) {
            child = p.right;
        }
        if (pp == null) {
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node pre(Node p) {
        if (root == null) {
            return null;
        }
        Node x = root;
        Node preNode = x.left;
        while (x != null) {
            if (x.data > p.data) {
                x = x.left;
                preNode = x.left;
            } else if (x.data < p.data) {
                preNode = x;
                x = x.right;
            } else {
                return preNode;
            }
        }
        return null;
    }

    public static class Node {
        int data;
        Node left;
        Node right;


        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
