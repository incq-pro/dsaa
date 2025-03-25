package pro.incq.dsaa.tree.binarytree;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return findMax(root).getElement();
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return findMin(root).getElement();
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public int size() {
        return size(root);
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(BinaryNode<T> root) {
        if(root == null) {
            return;
        }
        printTree(root.getLeft());
        System.out.println(root.getElement());
        printTree(root.getRight());
    }

    private boolean contains(T x, BinaryNode<T> root) {
        if (root == null) {
            return false;
        }
        int result = root.getElement().compareTo(x);
        if (result > 0) {
            return contains(x, root.getLeft());
        } else if (result < 0) {
            return contains(x, root.getRight());
        }
        return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }
        int result = x.compareTo(t.getElement());
        if (result > 0) {
            t.setRight(insert(x, t.getRight()));
        } else if (result < 0) {
            t.setLeft(insert(x, t.getLeft()));
        }
        return t;
    }

    private int size(BinaryNode<T> t) {
        if (t == null) {
            return 0;
        }
        int s = size(t.getLeft());
        s += size(t.getRight());
        return s + 1;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            return null; // nothing found
        }
        int result = x.compareTo(t.getElement());
        if (result > 0) {
            t.setRight(remove(x, t.getRight()));
        } else if (result < 0) {
            t.setLeft(remove(x, t.getLeft()));
        } else if (t.getLeft() != null && t.getRight() != null) {
            T e = findMin(t).getElement();
            t.setElement(e);
            t.setRight(remove(e, t.getRight()));
        } else {
            return (t.getLeft() == null ? t.getRight() : t.getLeft());
        }
        return t;
    }
}
