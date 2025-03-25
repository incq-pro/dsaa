package pro.incq.leetcode.dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int prepre = 1;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ": " + cs.climbStairs(i));
        }
    }
}
