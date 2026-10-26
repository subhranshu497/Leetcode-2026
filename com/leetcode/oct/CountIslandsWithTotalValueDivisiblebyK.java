package com.com.leetcode.oct;

import java.util.Arrays;

public class CountIslandsWithTotalValueDivisiblebyK {
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int [][] memo;
    public static void main(String[] args) {
        int [][] grid = {{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}};
        int k = 5;
        int count = countIslands(grid,k);
        System.out.println(count);
    }

    private static int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m+1][n+1];
        for(int [] mem:memo)
            Arrays.fill(mem, -1);
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long sum= countIslandssolve(grid, m,n, k, i,j);
                    if(sum>0 && sum % k==0) count +=1;
                }
            }
        }
        return count;
    }

    private static long countIslandssolve(int[][] grid, int m, int n, int k, int i, int j) {
        //base case
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]<=0)return 0;
        long sum =grid[i][j];
        //mark the cell visited
        grid[i][j] =-1;
        for(int [] dir:directions){
            int i_ = i+dir[0];
            int j_ = j+dir[1];
            sum +=countIslandssolve(grid,m,n,k,i_,j_);
        }
        return sum;
    }
}
