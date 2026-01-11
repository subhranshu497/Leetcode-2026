package com.jan;

import java.util.Arrays;

public class MinimumASCIIDeleteSumforTwoStrings {
    public static void main(String[] args) {
        String s1 = "eat";
        String s2 = "sea";
        int res = minimumDeleteSum(s1, s2);
        System.out.println(res);
    }

    private static int minimumDeleteSum(String s1, String s2) {
        int m =s1.length();
        int n = s2.length();
        int [][] dp = new int[m+1][n+1];
        for(int [] d:dp)
            Arrays.fill(d, -1);
        return minimumDeleteSumSolve(s1,s2,m,n,0,0,dp);
    }

    private static int minimumDeleteSumSolve(String s1, String s2, int m, int n, int i, int j, int[][] dp) {
        //base condition
        if(i>=m && j>=n) return 0;
        if(i>=m) return s2.charAt(j)+minimumDeleteSumSolve(s1, s2,m,n,i, j+1,dp);
        if(j>=n) return s1.charAt(i)+minimumDeleteSumSolve(s1, s2,m,n,i+1, j,dp);
        if(s1.charAt(i)==s2.charAt(j)) return minimumDeleteSumSolve(s1, s2,m,n,i+1, j+1,dp);
        if(dp[i][j] != -1) return dp[i][j];
        int del_s1_i = s1.charAt(i)+minimumDeleteSumSolve(s1,s2,m,n,i+1,j,dp);
        int del_s2_j = s2.charAt(j)+minimumDeleteSumSolve(s1,s2,m,n,i,j+1,dp);
        return dp[i][j] = Math.min(del_s1_i, del_s2_j);
    }
}
