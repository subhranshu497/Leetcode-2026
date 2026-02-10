package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 25;
        int res = tribonacci(n);
        System.out.println(res);
    }

    private static int tribonacci(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return tribonacciHelper(n, memo);

    }

    private static int tribonacciHelper(int n, int[] memo) {
        //base case
        if(n==0) return 0;
        if(n==1 ||n==2)return 1;
        if(memo[n] != -1) return memo[n];

        return memo[n] =tribonacciHelper(n-1, memo)+tribonacciHelper(n-2,memo)+tribonacciHelper(n-3,memo);
    }

//    private static int tribonacci(int n) {
//        int [] dp = new int[n+1];
//        if(n==0) return 0;
//        if(n==1) return 1;
//        if(n==2) return 1;
//        dp[0] = 0;
//        dp[1]=1;
//        dp[2] =1;
//        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
//        }
//        return dp[n];
//    }
}
