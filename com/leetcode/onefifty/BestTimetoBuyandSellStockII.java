package com.com.leetcode.onefifty;

public class BestTimetoBuyandSellStockII
{
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int profit = maxProfitIII(prices);
        System.out.println(profit);
    }

    private static int maxProfitIII(int[] prices) {
        int n = prices.length;
        int profit =0;
        int min = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]>min){
                profit +=prices[i]-min;
            }
            min = prices[i];
        }
        return profit;
    }
}
