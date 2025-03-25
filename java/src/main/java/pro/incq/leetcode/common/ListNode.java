package pro.incq.leetcode.common;

/**
 * 单向链表的节点
 *
 * @author incq.pro
 */
public class ListNode {
    public int val;

    public ListNode next;


    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
