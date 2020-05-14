package me.zqpro.dsaa.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yun.516@gmail.com
 */
public class ACAutoMata {
    private static final int LEN = 26;

    private ACNode root;

    public ACAutoMata() {
        root = new ACNode("/");
    }

    public void insert(String pattern) {
        if (pattern.isEmpty()) {
            return;
        }
        ACNode p = root;
        for (int i = 0; i < pattern.length(); i++) {
            String c = String.valueOf(pattern.charAt(i));
            ACNode node = p.children.get(c);
            if (node == null) {
                node = new ACNode(c);
                node.length = i + 1;
                p.children.put(c, node);
            }
            p = node;
        }
        p.isEndingChar = true;
    }

    public void buildFailurePointer() {
        root.fail = null;
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            for (ACNode pc : p.children.values()) {
                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = p.fail;
                    while (q != null) {
                        ACNode qn = q.children.get(pc.data);
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

    public boolean match(String text) {
        boolean ret = false;
        ACNode p = root;
        for(int i = 0; i < text.length(); i++) {
            String c = String.valueOf(text.charAt(i));
            while(p.children.get(c) == null && p != root) {
                p = p.fail;
            }
            p = p.children.get(c);
            if (p == null) {
                p = root;
            }
            ACNode tmp = p;
            while (tmp != root) {
                if (tmp.isEndingChar) {
                    System.out.println("Start from " + (i - p.length + 1));
                    ret = true;
                }
                tmp = tmp.fail;
            }
        }
        return ret;
    }

    private static class ACNode {
        String data;
        Map<String, ACNode> children = new HashMap<>();
        int length = -1;
        ACNode fail;
        boolean isEndingChar;

        ACNode(String data) {
            this.data = data;
        }
    }
}
