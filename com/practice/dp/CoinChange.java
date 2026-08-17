package com.com.practice.dp;

import java.util.Arrays;

public class CoinChange {
    private static int[][] memo;
    public static void main(String[] args) {
        int [] coins = {5,2,1};
        int amount =11;
        int res = coinChangeIDP(coins, amount);
        System.out.println(res);
    }

    private static int coinChangeIDP(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n+1][10001];
        //init the dp array with max value/2
        Arrays.fill(dp[n], Integer.MAX_VALUE/2);
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    dp[i][j] = 0;
                    continue;
                }
                int take = Integer.MAX_VALUE/2;
                if(j-coins[i] >= 0) {
                    take = 1 + dp[i][j - coins[i]];
                }
                int skip = dp[i+1][j];
                dp[i][j] = Math.min(take, skip);
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE/2?-1:dp[0][amount];
    }

//    private static int coinChangeI(int[] coins, int amount) {
//        int n = coins.length;
//        memo = new int[10001][n+1];
//        for(int [] m:memo)
//            Arrays.fill(m,-1);
//        int res = coinChangeISolve(coins, amount,n,0);
//        if(res==Integer.MAX_VALUE/2)
//            return -1;
//        return res;
//    }
//
//    private static int coinChangeISolve(int[] coins, int amount, int n, int i) {
//        //base case
//        if(i>=n || amount<0) return Integer.MAX_VALUE/2;
//        if(amount==0)return 0;
//        if(memo[amount][i] != -1)return memo[amount][i];
//        int take = 1+coinChangeISolve(coins, amount-coins[i],n,i);
//        int skip = coinChangeISolve(coins,amount,n,i+1);
//
//        return memo[amount][i] =Math.min(take,skip);
//    }
}
