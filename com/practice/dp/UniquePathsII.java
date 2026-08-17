package com.com.practice.dp;

import java.util.Arrays;

public class UniquePathsII {
    private static int [][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int path = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(path);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] memo = new int[m+1][n+1];
        for(int [] me:memo){
            Arrays.fill(me,-1);
        }
        int paths = uniquePathsWithObstaclesRecursion(obstacleGrid, m,n,0,0, memo);
        return paths;
    }

    private static int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int m, int n, int i, int j, int [][] memo) {
        //base case
        if(i<0 || i>=m || j<0 || j>=n)return 0;
        if(obstacleGrid[i][j]==1)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(memo[i][j] != -1)return memo[i][j];
        int paths =0;
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            paths +=uniquePathsWithObstaclesRecursion(obstacleGrid,m,n,i_,j_, memo);
        }
        return memo[i][j] = paths;
    }
}
