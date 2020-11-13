package pro.incq.leetcode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a, b) -> a.val < b.val ? -1 : 1);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.offer(lists[i]);
            }
        }
        ListNode head = q.poll();
        if (head == null) {
            return null;
        }
        ListNode p = head;
        if (p.next != null) {
            q.offer(p.next);
        }
        while (!q.isEmpty()) {
            ListNode n = q.poll();
            p.next = n;
            p = n;
            if (p.next != null) {
                q.offer(p.next);
            }
        }
        p.next = null;
        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


