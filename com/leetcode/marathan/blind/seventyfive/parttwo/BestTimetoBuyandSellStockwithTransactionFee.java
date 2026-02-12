package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;
import java.util.Map;

public class BestTimetoBuyandSellStockwithTransactionFee {
    private static int maxProfit =Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [] prices = {1,3,2,8,4,9};
        int fee = 2;
        int profit = maxProfitI(prices,fee);
        System.out.println(profit);
    }

    private static int maxProfitI(int[] prices, int fee) {
        int n = prices.length;
        int [][] t = new int[n][2];
        t[0][0] = 0;
        t[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            //buy
            t[i][1] = Math.max(t[i-1][1], t[i-1][0]-prices[i]);
            //sell
            t[i][0] = Math.max(t[i-1][0], t[i-1][1]+prices[i]-fee);
        }
        return t[n-1][0];
    }

//    private static int maxProfitI(int[] prices, int fee) {
//        int [][] memo = new int [prices.length+1][3];
//        for(int [] arr:memo)
//            Arrays.fill(arr, -1);
//       return maxProfitSolve(prices,fee,0,1, memo);
//    }
//
//    private static int maxProfitSolve(int[] prices, int fee, int i, int buy, int[][] memo) {
//        //base case
//        if(i>=prices.length){
//            return 0;
//        }
//        if(memo[i][buy] !=-1)return memo[i][buy];
//        int profit = 0;
//        //buy
//        if(buy==1){
//            profit = Math.max(-prices[i]+maxProfitSolve(prices,fee,i+1,0, memo),maxProfitSolve(prices,fee,i+1,buy, memo));
//        }else {
//            profit = Math.max(prices[i]-fee+maxProfitSolve(prices,fee,i+1,1, memo),maxProfitSolve(prices,fee,i+1,buy, memo));
//        }
//        return memo[i][buy] = profit;
//    }
}
