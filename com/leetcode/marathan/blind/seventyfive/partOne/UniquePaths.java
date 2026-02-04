package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class UniquePaths {
    private static int [][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int m = 3, n = 7;
        int ways = uniquePaths(m,n);
        System.out.println(ways);
    }

    private static int uniquePaths(int m, int n) {
        int t[][] = new int[m][n];
        //define the state - t[0][0] = no of ways to reach t[0][0] from start, here sart is t[0][0]
        t[0][0] = 0;
        //now start filling hte other states
        //first row - all the values would be 1 in the first row, because only moving right
        //first column - all the values would be 1 in the first col, because only moving down
        for(int i=1;i<m;i++)
            t[i][0] = 1;
        for(int i=1;i<n;i++)
            t[0][i] = 1;
        // now start traversing
        //robot can come to a new cell only from top which is t[i-1][j] or from left t[i][j-1]
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                t[i][j] = t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }

//    private static int uniquePaths(int m, int n) {
//        boolean [][] visited = new boolean[m][n];
//        int [][] memo = new int[m+1][n+1];
//        for(int[] me:memo)
//            Arrays.fill(me, -1);
//        return uniquePathsSolve(m,n,0,0,visited, memo);
//    }
//
//    private static int uniquePathsSolve(int m, int n, int i, int j, boolean[][] visited, int [][] memo) {
//        //check for the ans
//        if(i==m-1 && j==n-1) return 1;
//        //oob
//        if(i==m || j==n ||visited[i][j]) return 0;
//        if(memo[i][j] != -1) return memo[i][j];
//        //start backbracking - do
//        visited[i][j] = true;
//        //explore
//        int ways =0;
//        for(int [] dir:directions){
//            int i_ = i+dir[0];
//            int j_ = j+dir[1];
//            ways += uniquePathsSolve(m,n,i_,j_,visited, memo);
//        }
//        //undo
//        visited[i][j] = false;
//        return memo[i][j] = ways;
//    }
}
