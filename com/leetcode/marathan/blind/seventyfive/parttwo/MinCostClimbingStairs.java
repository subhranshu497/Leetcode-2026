package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int [] costs = {10,15,20};
        int steps = minCostClimbingStairs(costs);
        System.out.println(steps);
    }

    private static int minCostClimbingStairs(int[] costs) {
        int n = costs.length;
        return minCostSolve(costs, 0,n);
    }

    private static int minCostSolve(int[] costs, int i, int n) {
        if(i>=n) return 0;
        //take
        int take1 =costs[i]+minCostSolve(costs, i+1,n);
        int take2 =costs[i+1]+minCostSolve(costs, i+2,n);

        return Math.min(take1, take2);
    }
}
