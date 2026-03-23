package com.com.leetcode.march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNonNegativeProductinaMatrix {
    private static int MOD = 1000000007;
    private static Map<String, long[]> memo = new HashMap<>();
    private static Long maxProd = Long.MIN_VALUE;
    private static int[][] directions = {{1,0},{0,1}};
    public static void main(String[] args) {
        int [][] grid = {{1,3},{0,-4}};
        int res = maxProductPath(grid);
        System.out.println(res);
    }

    private static int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //the 3rd dim is for storing the maxval and minVal [0]-maxVal , [1] - minVal
        long [][][] memo = new long [m][n][2];
        //fill the initial state for 0th row and 0th col
        //for 0th row - value from top is not possible so
        memo[0][0][0] = grid[0][0];
        memo[0][0][1] = grid[0][0];
        for(int k=1;k<n;k++){
            long temp = memo[0][k-1][0]*grid[0][k];
            memo[0][k][0] = temp;
            memo[0][k][1] = temp;
        }
        //fill the first column
        // since no movement is possible from left
        for(int k=1;k<m;k++){
            long temp =memo[k-1][0][0]*grid[k][0];
            memo[k][0][0] = temp;
            memo[k][0][1] = temp;
        }
        //fill the dp
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long up_max = memo[i-1][j][0];
                long up_min = memo[i-1][j][1];
                long left_max = memo[i][j-1][0];
                long left_min = memo[i][j-1][1];

                long maxVal = Math.max(up_max*grid[i][j], Math.max(up_min*grid[i][j], Math.max(left_max*grid[i][j],left_min*grid[i][j])));
                long minVal = Math.min(up_max*grid[i][j], Math.min(up_min*grid[i][j], Math.min(left_max*grid[i][j],left_min*grid[i][j])));
                memo[i][j][0]=maxVal;
                memo[i][j][1] =minVal;
            }
        }
        long maxProd = memo[m-1][n-1][0] % MOD;
         return (int)(maxProd <0?-1:maxProd);
    }


//    private static int maxProductPath(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        long [] pair = solveMaxProd(0,0,m,n, grid);
//        //0th val is max val , 1st val is min
//        long maxProd = pair[0];
//        return (int)((maxProd<0?-1:maxProd)%MOD);
//    }
//
//    private static long[] solveMaxProd(int i, int j, int m, int n, int[][] grid) {
//        String key = i+","+j;
//        if(memo.containsKey(key))
//            return memo.get(key);
//        //base case
//        if(i==m-1 && j==n-1)
//            return new long[]{grid[i][j], grid[i][j]};
//
//        long maxVal = Long.MIN_VALUE;
//        long minVal = Long.MAX_VALUE;
//        //down
//        if(i+1 <m){
//            long [] down = solveMaxProd(i+1, j,m,n, grid);
//            long p1 = grid[i][j]*down[0];
//            long p2 = grid[i][j]*down[1];
//            maxVal = Math.max(Math.max(maxVal,p1),p2);
//            minVal = Math.min(Math.min(minVal,p1),p2);
//        }
//        //right
//        if(j+1 <n){
//            long [] right = solveMaxProd(i, j+1,m,n, grid);
//            long p1 = grid[i][j]*right[0];
//            long p2 = grid[i][j]*right[1];
//            maxVal = Math.max(Math.max(maxVal,p1),p2);
//            minVal = Math.min(Math.min(minVal,p1),p2);
//        }
//        long [] res = new long[]{maxVal, minVal};
//        memo.put(key, res);
//        return res;
//    }

}
