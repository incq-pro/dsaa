package linkedlist;

/**
 * @author yun.516@gmail.com
 */
public class LinkedListAlgo {

    public static Node reverse(Node list) {
        Node pre = null;
        Node curr = list;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node slow = list;
        Node fast = list.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        Node head = null;
        Node pa = la;
        Node pb = lb;
        if (pa.value < pb.value) {
            head = pa;
            pa = pa.next;
        } else {
            head = pb;
            pb = pb.next;
        }
        Node tail = head;

        while (pa != null && pb != null) {
            if (pa.value < pb.value) {
                tail.next = pa;
                pa = pa.next;
            } else {
                tail.next = pb;
                pb = pb.next;
            }
            tail = tail.next;
        }
        if (pa == null) {
            tail.next = pb;
        } else {
            tail.next = pa;
        }
        return head;
    }

    public static Node deleteLastKth(Node list, int k) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        for (int i = 1; fast != null && i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return list;
        }
        Node pre = null;
        Node slow = list;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }


    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node slow = list;
        Node fast = list;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static class Node {
        int value;
        Node next;
    }
}
