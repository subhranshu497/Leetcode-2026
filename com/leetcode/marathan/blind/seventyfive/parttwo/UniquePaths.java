package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;

public class UniquePaths {
    private static int[][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int m = 3, n =7;
        int count = uniquePathsI(m,n);
        System.out.println(count);
    }

    private static int uniquePathsI(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)dp[i][j]=1;
                else{
                    int wayFromtop =(i>0)?dp[i-1][j]:0;
                    int wayFromLeft = (j>0)?dp[i][j-1]:0;
                    dp[i][j] = wayFromLeft+wayFromtop;
                }
            }
        }
        return dp[m-1][n-1];
    }

//    private static int uniquePathsI(int m, int n) {
//        boolean [][] visited = new boolean[m][n];
//        int [][] memo = new int[m][n];
//        for(int [] arr:memo)
//            Arrays.fill(arr, -1);
//        return solveDfs(m,n,0,0,visited, memo);
//    }
//
//    private static int solveDfs(int m, int n, int i, int j, boolean[][] visited, int[][] memo) {
//        //check for oob
//        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])return 0;
//        if(i==m-1 && j==n-1) return 1;
//        if(memo[i][j] != -1) return memo[i][j];
//        visited[i][j] = true;
//        int count =0;
//        for(int [] direction:directions){
//            int i_ = i+direction[0];
//            int j_ = j+direction[1];
//
//            count +=solveDfs(m,n,i_,j_,visited, memo);
//        }
//        visited[i][j] = false;
//        return count;
//    }
}
