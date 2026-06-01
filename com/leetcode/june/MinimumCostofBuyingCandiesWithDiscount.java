package com.com.leetcode.june;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCostofBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        int [] cost = {1,2,3};
        int result = minimumCostIIII(cost);
        System.out.println(result);
    }

    private static int minimumCostIIII(int[] cost) {
        int totalCost = 0;
        //sort the cost array in descending order
        int [] sortedCost = Arrays.stream(cost)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        for(int i=0;i<sortedCost.length;i +=3){
            totalCost += sortedCost[i]+((i+1)<sortedCost.length?sortedCost[i+1]:0);
        }
        return totalCost;
    }
}
