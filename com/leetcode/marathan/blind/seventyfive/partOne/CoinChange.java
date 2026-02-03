package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class CoinChange {
    private static int minCount =Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] coins = {2};
        int target = 3;
        minCount = coinChange(coins, target);
        System.out.println(minCount);
    }

    private static int coinChange(int[] coins, int target) {
        int n = coins.length;
        int [][] dp = new int[n+1][target+1];
        //by using denmination 0 coin, if we want to achieve target amount of money , then we need infinite numbers of coins
//        for(int [] arr:dp){
//            Arrays.fill(arr, Integer.MAX_VALUE);
//        }
        for(int i=0;i<=target;i++)
            dp[0][i] = Integer.MAX_VALUE;
        //make 0 amout of money by using 0 coins
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        //but to achieve 0 amount , we dont need any coins
        dp[0][0] =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                //skip
                //since we are skiping the coin , so just take the number from above cell where we have already precalculated the value
                int skip = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                //in case of take 1+
                //take the value from the amount grid, which was already calculated
                //first check if the achieved amount is greater or equal to the coin denomination
                if(j>=coins[i-1]){
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE)
                        take = 1+dp[i][j-coins[i-1]];
                }
                dp[i][j] = Math.min(skip, take);
            }
        }
        for(int i=0;i<=n;i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }
        return dp[n][target]==Integer.MAX_VALUE?-1:dp[n][target];
    }

//    private static int coinChange(int[] coins, int amount) {
//        int n = coins.length;
//        int [][] memo = new int[n+1][amount+1];
//        for(int [] arr:memo)
//            Arrays.fill(arr, -1);
//        int count = coinChangeRecursion(coins,amount,amount,0,n, memo);
//
//        return count==amount+1?-1:count;
//    }
//
//    private static int coinChangeRecursion(int[] coins, int target, int rem, int i, int n, int [][] memo) {
//        if(i>=n || rem<0)return target+1;
//        if(rem==0)return 0;
//        if(memo[i][rem] !=-1)return memo[i][rem];
//        //take
//        int take = 1+coinChangeRecursion(coins,target,rem-coins[i],i,n, memo);
//        //skip
//        int skip = coinChangeRecursion(coins,target,rem,i+1,n, memo);
//
//        return memo[i][rem] = Math.min(take, skip);
//    }
}
