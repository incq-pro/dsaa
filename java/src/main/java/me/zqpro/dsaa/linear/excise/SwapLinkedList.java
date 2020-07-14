package me.zqpro.dsaa.linear.excise;

public class SwapLinkedList {
    private static class Node {
        Node next;
        int data;
    }

    private static class DoublyNode extends Node {
        Node pre;
    }

    public static  void swap(Node pp) {
        Node p = pp.next;

        Node n = p.next;
        p.next = n.next;
        n.next = p;
        pp.next = n;
    }

    public static void print(Node p) {
        while (p != null) {
            System.out.printf("%d->", p.data);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Node p = new Node();
        Node head = p;
        p.data = 0;
        p.next = new Node();
        p.next.data = 1;
        p = p.next;
        p.next = new Node();
        p.next.data = 2;
        print(head);
        swap(head);
        System.out.println();
        print(head);
    }
}
