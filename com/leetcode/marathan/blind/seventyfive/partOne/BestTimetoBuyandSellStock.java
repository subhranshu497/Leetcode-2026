package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
       int profit = 0;
       int min = prices[0];
       for(int i=1;i<n;i++){
           if(prices[i]<min)
               min = prices[i];
           profit = Math.max(profit,prices[i]-min);
       }
        return profit;
    }
}
