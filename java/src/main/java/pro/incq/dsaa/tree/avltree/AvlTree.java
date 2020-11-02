package pro.incq.dsaa.tree.avltree;

public class AvlTree<T extends Comparable<? super T>> {

    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T element) {
            this(element, null, null);
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private AvlNode<T> root;

    public AvlTree() {
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    private int height(AvlNode<T> root) {
        return root == null ? -1 : root.height;
    }

    // todo impl
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            return new AvlNode<>(x);
        }
        int compareResult = t.element.compareTo(x);
        if (compareResult < 0) {
            t.right = insert(x, t.right);
        } else if (compareResult > 0) {
            t.left = insert(x, t.left);
        } else {
            return t;
        }
        return balance(t);
    }


    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = t.left == null ? t.right : t.left;
        }
        return balance(t);
    }

    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null) {
            return null;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.left = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.left)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k2;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.left)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
}
