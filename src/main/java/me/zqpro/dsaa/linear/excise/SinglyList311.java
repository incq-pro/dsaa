package me.zqpro.dsaa.linear.excise;

public class SinglyList311<T> {

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

    public SinglyList311() {
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
        Node<T> p = header.next;
        while (p != null) {
            if (p.data == null) {
                if (data == null) {
                    return true;
                }
            } else if (p.data.equals(data)){
                return true;
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
        while (p.next != null) {
            if (p.next.data == null) {
                if (data == null) {
                    return false;
                }
            } else if (p.next.data.equals(data)) {
                return false;
            }
            p = p.next;
        }
        p.next = new Node<>(data, null);
        size++;
        return true;
    }

    /**
     * 如果data存在于链表，从中删除
     */
    public boolean remove(T data) {
        Node<T> p = header;
        while (p != null && p.next != null) {
            if (p.next.data == null) {
                if (data == null) {
                    p.next = p.next.next;
                    --size;
                    return true;
                }
            } else if (p.next.data.equals(data)) {
                p.next = p.next.next;
                --size;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyList311<Integer> list = new SinglyList311<>();
        list.addIfAbsent(0);
        System.out.println(list.size);
        list.printList();
        list.addIfAbsent(1);
        list.addIfAbsent(2);
        list.addIfAbsent(3);
        list.addIfAbsent(4);
        list.addIfAbsent(4);
        System.out.println(list.size());
        list.printList();
        list.remove(5);
        list.remove(4);
        list.printList();
    }
}
