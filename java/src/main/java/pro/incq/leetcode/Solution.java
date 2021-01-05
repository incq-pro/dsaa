package pro.incq.leetcode;

/**
 * leetcode
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m <= 0 || n <= 0 || m >= n) {
            return head;
        }
        int index = 1;
        ListNode pre = null;
        ListNode nodeM = head;
        for(index = 1; index < m; index++) {
            pre = nodeM;
            nodeM = nodeM.next;
        }
        ListNode cur = nodeM.next;
        nodeM.next = pre;
        pre = nodeM;
        for(;index < n; index++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (nodeM.next != null) {
            nodeM.next.next = pre;
            nodeM.next = cur;
            return head;
        } else {
            nodeM.next = cur;
            return pre;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode x = new Solution().reverseBetween(head, 2, 4);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}


