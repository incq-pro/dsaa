package pro.incq.dsaa.linear.excise;

import java.util.Objects;

public class SinglyList312<T extends Comparable<T>> {

    private static class Node<T> {
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        T data;
        Node<T> next;
    }

    private Node<T> header;
    private int size;

    public SinglyList312() {
        header = new Node<>(null, null);
        size = 0;
    }

    /**
     * 返回链表大小的方法
     */
    public int size() {
        return size;
    }

    /**
     * 打印链表
     */
    public void printList() {
        Node<T> p = header.next;
        while (p != null) {
            System.out.printf("%s ", p.data);
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 判断是否包含元素data
     */
    public boolean contains(T data) {
        Objects.requireNonNull(data);

        Node<T> p = header.next;
        while (p != null) {
            if (p.data.equals(data)){
                return true;
            } else if (p.data.compareTo(data) < 0) {
                return false;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * 如果元素不存在于链表，则加入到链表中
     */
    public boolean addIfAbsent(T data) {
        Node<T> p = header;
        while (p != null && p.next != null) {
            if (p.next.data.equals(data)) {
                return false;
            } else if (p.next.data.compareTo(data) > 0) {
                addAfter(p, data);
                return true;
            }
            p = p.next;
        }
        addAfter(p, data);
        return true;
    }

    /**
     * 如果data存在于链表，从中删除
     */
    public boolean remove(T data) {
        Node<T> p = header;
        while (p != null && p.next != null) {
            if (p.next.data.equals(data)) {
                p.next = p.next.next;
                --size;
                return true;
            } else if (p.next.data.compareTo(data) > 0) {
                return false;
            }
            p = p.next;
        }
        return false;
    }

    private Node<T> addAfter(Node<T> p, T data) {
        Node<T> n = new Node<>(data, p.next);
        p.next = n;
        ++size;
        return n;
    }

    public static void main(String[] args) {
        SinglyList312<Integer> list = new SinglyList312<>();
        list.addIfAbsent(0);
        System.out.println(list.size);
        list.printList();
        list.addIfAbsent(6);
        list.addIfAbsent(6);
        list.addIfAbsent(5);
        list.addIfAbsent(5);
        list.addIfAbsent(3);
        list.addIfAbsent(4);
        list.addIfAbsent(10);
        System.out.println(list.size());
        list.printList();
        list.remove(5);
        list.remove(4);
        list.printList();
    }
}
