package com.com.leetcode.nov;

public class MinimumCosttoAcquireRequiredItems {
    public static void main(String[] args) {
        int cost1 = 5, cost2 = 4, costBoth = 15, need1 = 2, need2 = 3;
        long res = minimumCostV(cost1, cost2,costBoth,need1, need2);
        System.out.println(res);
    }

    private static long minimumCostV(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minCost = Long.MAX_VALUE;

        // Strategy 1 - Meet req only using type 1 and type 2
        long individualCost = (long) cost1 * need1 + (long) cost2 * need2;
        minCost = Math.min(minCost, individualCost);

        // Strategy 2 - Meet req only using type 3
        long maxNeed = Math.max(need1, need2);
        long bothCost = maxNeed * costBoth;
        minCost = Math.min(minCost, bothCost);

        // Strategy 3 - Mix type 3 items with either type 1 or type 2
        long commonNeed = Math.min(need1, need2);
        long remainingNeed1 = need1 - commonNeed;
        long remainingNeed2 = need2 - commonNeed;
        long commonCost = commonNeed * costBoth + remainingNeed1 * cost1 + remainingNeed2 * cost2;
        minCost = Math.min(minCost, commonCost);

        return minCost;
    }
}
