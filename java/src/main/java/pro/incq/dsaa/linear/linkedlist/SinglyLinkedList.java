package pro.incq.dsaa.linear.linkedlist;

import java.util.Stack;

/**
 * @author yun.516@gmail.com
 */
public class SinglyLinkedList {

    private Node head;
    private int size;

    public SinglyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public boolean add(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node(value, null);
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
                head = new Node(value, null);
            } else {
                head = new Node(value, head);
            }
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = new Node(value, p.next);
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
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        --size;
        return true;
    }

    /**
     * reverse with O(1) space
     */
    public void reverse() {
        Node pre = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
    }

    public boolean checkCircle() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public int getMiddle() {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    public static SinglyLinkedList merge(SinglyLinkedList a, SinglyLinkedList b) {
        SinglyLinkedList c = new SinglyLinkedList();
        Node pa = a.head;
        Node pb = b.head;
        while (pa != null && pb != null) {
            if (pa.value <= pb.value) {
                c.add(pa.value);
                pa = pa.next;
            } else {
                c.add(pb.value);
                pb = pb.next;
            }
        }
        while (pa != null) {
            c.add(pa.value);
            pa = pa.next;
        }
        while (pb != null) {
            c.add(pb.value);
            pb = pb.next;
        }
        return c;
    }

    public void deleteLastKth(int k) {
        if (k <= 0 || k > size) {
            throw new IndexOutOfBoundsException();
        }

    }

    public boolean contains(int value) {
        Node p = head;
        while (p != null) {
            if (p.value == value) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * reverse with a stack
     */
    public void reverseWithStack() {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        head = stack.pop();
        p = head;
        while (!stack.isEmpty()) {
            Node p2 = stack.pop();
            p.next = p2;
            p = p2;
        }
        p.next = null;
    }

    public void reverseRecursive() {
        Node p = doReverseRecursive(head);
        if (p != null) {
            p.next = null;
        }
    }

    /**
     *
     * @param
     * @return tail
     */
    private Node doReverseRecursive(Node p) {
        if (p == null) {
            return null;
        }
        if (p.next == null) {
            head = p;
            return p;
        }
        Node p2 = doReverseRecursive(p.next);
        p2.next = p;
        return p;
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.printf("%d ", p.value);
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        System.out.println(singlyLinkedList.contains(0));
        System.out.println(singlyLinkedList.contains(1));
        System.out.println(singlyLinkedList.contains(2));
        System.out.println(singlyLinkedList.contains(3));
        singlyLinkedList.print();
        singlyLinkedList.reverseRecursive();
        singlyLinkedList.print();
    }
}
