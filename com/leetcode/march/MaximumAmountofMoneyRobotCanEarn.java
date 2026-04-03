package com.com.leetcode.march;

import java.util.Arrays;

public class MaximumAmountofMoneyRobotCanEarn {
    private static int maxMoney = 0;
    public static void main(String[] args) {
        int [][] coins = {{0,1,-1},{1,-2,3},{2,-3,4}};
        int res = maxMoney(coins);
        System.out.println(res);
    }

    private static int maxMoney(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int specialAbility =2;
        int [][][] dp = new int[m+1][n+1][specialAbility+1];
        for(int [][] a:dp){
            for(int [] b:a){
                Arrays.fill(b, Integer.MIN_VALUE);
            }
        }
        return solve(coins, 0, 0, m, n, specialAbility, dp);

    }

    private static int solve(int[][] coins, int i, int j, int m, int n, int specialAbility, int[][][] dp) {
        //base case
        if(i==m-1 && j==n-1){
            if(coins[i][j] < 0 && specialAbility >0)
                return 0;
            return coins[i][j];
        }
        //out of bound check
        if(i>=m || j>=n)
            return Integer.MIN_VALUE;
        if(dp[i][j][specialAbility] != Integer.MIN_VALUE)
            return dp[i][j][specialAbility];
        //case for take
        int take = coins[i][j]+ Math.max(solve(coins, i+1, j, m, n, specialAbility, dp), solve(coins, i, j+1, m, n, specialAbility,dp));

        //case for skip
        int skip = Integer.MIN_VALUE;
        if(coins[i][j] < 0 && specialAbility >0){
            skip = Math.max(solve(coins, i+1, j, m, n, specialAbility-1,dp), solve(coins, i, j+1, m, n, specialAbility-1,dp));
            return Math.max(take, skip);
        }
        return dp[i][j][specialAbility]=Math.max(take, skip);
    }


}
