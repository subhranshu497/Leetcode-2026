package com.com.leetcode.concept.recursion;

import java.util.Arrays;

public class MinimumPathSum {
    private static int[][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] memo = new int[m][n];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        int minSum = solveMinSum(grid, 0,0,0,m,n, memo);
        return minSum;
    }

    private static int solveMinSum(int[][] grid, int i, int j, int sum, int m, int n, int [][] memo) {
        //base case
        if(i==m-1 && j==n-1){
            return  grid[i][j] ;
        }
        if(memo[i][j] !=-1)return memo[i][j];
        sum =Integer.MAX_VALUE;
        for(int [] direction: directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(i_ <m && j_ < n){
                int res = solveMinSum(grid, i_,j_, sum, m,n, memo);
                sum = Math.min(sum, res);
            }
        }
        memo[i][j] = grid[i][j] + sum;
        return memo[i][j];
    }
}
