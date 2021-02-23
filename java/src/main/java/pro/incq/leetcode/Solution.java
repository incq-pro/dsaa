package pro.incq.leetcode;

import java.util.ArrayList;
import java.util.List;

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

    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }
        List<Boolean> result = new ArrayList<>(A.length);
        int sum = 0;
        int n = A.length;
        for(int i = 0; i < n; i++) {
            sum = ((sum << 1) + A[i]) % 10;
            result.add((sum == 0 || sum == 5));
        }
        return result;
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


