package tree.binarytree;

import java.util.LinkedList;

public class ExpressTree {
    private BinaryNode root;

    public boolean parseSuffix(String exp) {
        String[] elements = exp.split(" ");
        LinkedList<BinaryNode> stack = new LinkedList<>();
        for(String x : elements) {
            BinaryNode bn;
            if (isOp(x)) {
                BinaryNode right = stack.pollLast();
                BinaryNode left = stack.pollLast();
                bn = new BinaryNode(x, left, right);
            } else {
                bn = new BinaryNode(x, null, null);
            }
            stack.add(bn);
        }
        root = stack.pollLast();
        return true;
    }

    public String printSuffix() {
        StringBuffer sb = new StringBuffer();
        printSuffix(root, sb);
        return sb.toString();
    }

    private void printSuffix(BinaryNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            printSuffix(root.getLeft(), sb);
        }
        if (root.getRight() != null) {
            printSuffix(root.getRight(), sb);
        }
        sb.append(" ");
        sb.append(root.getElement().toString());
    }

    private boolean isOp(String x) {
        return "+".equals(x) || "-".equals(x) || "*".equals(x);
    }
}
