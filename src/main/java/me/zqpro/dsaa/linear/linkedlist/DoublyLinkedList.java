package me.zqpro.dsaa.linear.linkedlist;

/**
 * @author yun.516@gmail.com
 */
public class DoublyLinkedList {

    private Node head;
    int size;

    public DoublyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public boolean add(int value) {
        if (head == null) {
            head = new Node(null, value, null);
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node(p, value, null);
        }
        size++;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (head == null) {
                head = new Node(null, value, null);
            } else {
                Node x = new Node(null, value, head);
                head.pre = x;
                head = x;
            }
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            Node x = new Node(p, value, p.next);
            if (p.next != null) {
                p.next.pre = x;
            }
            p.next = x;
        }
        ++size;
        return true;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.value;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.pre = null;
            }
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next.pre = p;
            p.next = p.next.next;
        }
        --size;
        return true;
    }

    private static class Node {
        int value;
        Node pre;
        Node next;

        Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}
