package me.zqpro.dsaa.linear.stack;

/**
 * @author yun.516@gmail.com
 */
public class LinkedStack {
    private Node head;
    int size;

    public LinkedStack() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean push(String item) {
        head = new Node(item, head);
        ++size;
        return true;
    }

    public String pop() {
        if (head != null) {
            String ret = head.item;
            head = head.next;
            --size;
            return ret;
        }
        return null;
    }

    public String head() {
        if (head != null) {
            return head.item;
        }
        return null;
    }

    private static class Node {
        String item;
        Node next;

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
