package com.com.practice.dp;

import java.util.Arrays;

public class UniquePaths {
    private static int [][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int m =3, n =2;
        int res = uniquePathsII(m,n);
        System.out.println(res );
    }

    private static int uniquePathsII(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        //init the state
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1)continue;
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }

//    private static int uniquePathsII(int m, int n) {
//        int [][] memo = new int[m+1][n+1];
//        for(int [] me:memo)
//            Arrays.fill(me,-1);
//        int path = uniquePathRecursion(m,n,0,0, memo);
//        return path;
//    }
//
//    private static int uniquePathRecursion(int m, int n, int i, int j,int[][] memo) {
//        //base case
//        if(i==m-1 && j==n-1) return 1;
//        if(i<0 || i>=m || j<0 || j>=n)return 0;
//        if(memo[i][j] != -1) return memo[i][j];
//        int res =0;
//        for(int [] direction:directions){
//            int i_ = i+direction[0];
//            int j_ = j+direction[1];
//            res +=uniquePathRecursion(m,n,i_,j_, memo);
//        }
//        return memo[i][j] = res;
//    }
}
