package com.com.leetcode.oct;

public class MinimumXORPathinaGrid {
    private static int minCostVal = Integer.MAX_VALUE;
    private static int[][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int [][] grid = {{1,2},{3,4}};
        minCostVal = minCostII(grid);
        System.out.println(minCostVal);
    }

    private static int minCostII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxVal = 0;
        for(int[] row:grid){
            for(int v:row) maxVal = Math.max(maxVal, v);
        }
        int costRange = Math.max(1, Integer.highestOneBit(maxVal)<<1);
        int[][][] memo = new int[m][n][costRange];
        minCostSolveI(grid, m,n,0,0,0,visited,memo);
        return minCostVal;
    }

    private static void minCostSolveI(int[][] grid, int m, int n, int i, int j, int cost, boolean[][] visited, int[][][] memo) {
        //base case
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j])return;
        //collect the ans
        if(i==m-1 && j==n-1){
            cost ^=grid[i][j];
            minCostVal = Math.min(minCostVal, cost);
            return;
        }
        if(memo[i][j][cost]==1)return;
        memo[i][j][cost] = 1;

        visited[i][j] = true;
        cost ^=grid[i][j];
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            minCostSolveI(grid,m,n,i_,j_,cost,visited,memo);
        }
        visited[i][j]=false;
    }
}
