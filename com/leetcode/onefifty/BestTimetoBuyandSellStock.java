package com.com.leetcode.onefifty;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int profit = maxProfitII(prices);
        System.out.println(profit);
    }

    private static int maxProfitII(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        return maxProfit;
    }
}
