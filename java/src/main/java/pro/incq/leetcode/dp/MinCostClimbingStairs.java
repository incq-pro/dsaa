package pro.incq.leetcode.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i = 2; i < n; i++) {
            minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i];
        }
        return Math.min(minCost[n - 1], minCost[n - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(mccs.minCostClimbingStairs(cost));

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(mccs.minCostClimbingStairs(cost));
    }
}

