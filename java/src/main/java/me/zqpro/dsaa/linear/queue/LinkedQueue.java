package me.zqpro.dsaa.linear.queue;

/**
 * @author yun.516@gmail.com
 */
public class LinkedQueue {
    private Node head;
    private Node tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean enqueue(String item) {
        if (tail == null) {
            tail = new Node(item, null);
            head = tail;
        } else {
            Node x = new Node(item, null);
            tail.next = x;
            tail = x;
        }
        ++size;
        return true;
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String ret = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        --size;
        return ret;
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
