package  pro.incq.dsaa.string;

import java.util.*;

/**
 * @author yun.516@gmail.com
 */
public class ACAutoMata2 {
    private ACNode root = new ACNode('/');

    public ACAutoMata2() {

    }

    public void add(String pattern) {
        if (doAdd(pattern)) {
            buildFailurePointer();
        }
    }

    public void addAll(Collection<String> patterns) {
        boolean added = false;
        for (String pattern : patterns) {
            if (doAdd(pattern)) {
                added = true;
            }
        }
        System.out.println("added");
        if (added) {
            buildFailurePointer();
        }
    }

    public void remove(String pattern) {
        if (doRemove(pattern)) {
            buildFailurePointer();
        }
    }

    public void removeAll(Collection<String> patterns) {
        boolean modified = false;
        for (String pattern : patterns) {
            if (doRemove(pattern)) {
                modified = true;
            }
        }
        if (modified) {
            buildFailurePointer();
        }
    }

    private boolean doAdd(String pattern) {
        boolean modified = false;
        ACNode p = root;
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            ACNode pc = p.children.get(c);
            if (pc == null) {
                pc = new ACNode(c);
                pc.length = i + 1;
                modified = true;
                p.children.put(c, pc);
            }
            p = pc;
        }
        if (!p.isEnd) {
            p.isEnd = true;
            modified = true;
        }
        return modified;
    }


    private boolean doRemove(String pattern) {
        return false;
    }

    public boolean match(String text) {
        boolean matched = false;
        ACNode p = root;
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            ACNode pc;
            while ((pc = p.children.get(c)) == null && p != root) {
                p = p.fail;
            }
            if (pc == null) {
                p = root;
            } else {
                p = pc;
                ACNode tmp = p;
                while (tmp != root) {
                    if (tmp.isEnd) {
                        matched = true;
                        System.out.println("match: " + (i - tmp.length + 1) + ", length: " + tmp.length);
                    }
                    tmp = tmp.fail;
                }
            }
        }
        return matched;
    }

    private void buildFailurePointer() {
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        root.fail = null;
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            for (ACNode pc : p.children.values()) {
                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = pc.fail;
                    while (q != null) {
                        ACNode qn = q.children.get(pc.val);
                        if (qn != null) {
                            q = qn;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    } else {
                        pc.fail = q;
                    }
                }
                queue.add(pc);
            }
        }
    }


    private static class ACNode {
        Character val;
        int length = -1;
        boolean isEnd;
        Map<Character, ACNode> children = new HashMap<>();
        ACNode fail;

        ACNode(Character val) {
            this.val = val;
        }
    }
}
