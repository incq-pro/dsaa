package me.zqpro.dsaa.linear.excise;

public class SinglyListQueue332<T> {
    private static class Node<T> {
        T d;
        Node<T> next;

        public Node(T d, Node<T> next) {
            this.d = d;
            this.next = next;
        }
    }

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T d) {
        if (tail == null) {
            head = tail = new Node<>(d, null);
        } else {
            tail.next = new Node<>(d, null);
            tail = tail.next;
        }
    }

    public T dequeue() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        T d = head.d;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return d;
    }

    public static void main(String[] args) {
        SinglyListQueue332<Integer> q = new SinglyListQueue332<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
