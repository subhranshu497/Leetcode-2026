package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;
import java.util.Map;

public class MinimumCostPathwithTeleportations {

    int destination;
    public static void main(String[] args) {
        int [][] grid = {{1,3,3},{2,5,4},{4,3,5}};
        int k = 2;
        int min = minCostI(grid, k);
        System.out.println(min);
    }

    private static int minCostI(int[][] grid, int k) {
        int range = 10000;
        int m= grid.length;
        int n = grid[0].length;
        int [][][] dp = new int[k+1][m][n];
        for(int [][] two:dp){
            for(int[] one :two){
                Arrays.fill(one, Integer.MAX_VALUE);
            }
        }
        int [] bestPrefix = new int[range+1];
        Arrays.fill(bestPrefix, Integer.MAX_VALUE);
        for(int p=0;p<=k;p++){
            int [] bestCurrent = new int[range+1];
            Arrays.fill(bestCurrent,Integer.MAX_VALUE);
            //apply bottom up
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i==m-1 && j==n-1)dp[p][m-1][n-1]=0;
                    else{
                        int ans= Integer.MAX_VALUE;
                        //down - since we r in bottoms up , so moving up
                        if(i+1 < m){
                            ans = Math.min(ans,grid[i+1][j]+dp[p][i+1][j]);
                        }
                        if(j+1 < n){
                            ans = Math.min(ans,grid[i][j+1]+dp[p][i][j+1]);
                        }
                        if(p>0){
                            ans = Math.min(ans, bestPrefix[grid[i][j]]);
                        }
                        dp[p][i][j] =ans;
                    }
                   bestCurrent[grid[i][j]] = Math.min(bestCurrent[grid[i][j]],dp[p][i][j]);
                }
            }
            Arrays.fill(bestPrefix, Integer.MAX_VALUE);
            bestPrefix[0] = bestCurrent[0];
            for(int i=1;i<=range;i++){
                bestPrefix[i] = Math.min(bestCurrent[i], bestPrefix[i-1]);
            }
        }
        return dp[k][0][0];
    }


    //recursion+memo - gave tle
//    private static int minCostI(int[][] grid, int k) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int [][][] memo = new int[m][n][k+1];
//        for(int [][] two:memo){
//            for(int[] one:two){
//                Arrays.fill(one,Integer.MAX_VALUE);
//            }
//        }
//        return minCostRecursion(grid,k,m,n,0,0, memo);
//    }
//
//    private static int minCostRecursion(int[][] grid, int k, int m, int n, int i, int j, int[][][] memo) {
//        //base case
//        if(i==m-1 && j==n-1) return 0;
//        if(memo[i][j][k] !=Integer.MAX_VALUE) return memo[i][j][k];
//
//        int ans = Integer.MAX_VALUE;
//        //3 ops are possible 1. down 2.right 3.teleport
//        if(i+1 <m){
//            int down = grid[i+1][j]+minCostRecursion(grid,k,m,n,i+1,j, memo);
//            if(down != Integer.MAX_VALUE){
//                ans = Math.min(ans, down);
//            }
//        }
//        if(j+1 <n){
//            int right = grid[i][j+1]+minCostRecursion(grid,k,m,n,i,j+1,memo);
//            if(right != Integer.MAX_VALUE){
//                ans = Math.min(ans, right);
//            }
//        }
//        //case of teleportation
//        if(k>0){
//            int curr = grid[i][j];
//            for(int p=0;p<m;p++){
//                for(int q=0;q<n;q++){
//                    if(p==i && q==j)continue;
//                    if(curr >=grid[p][q]){
//                        int teleportation = minCostRecursion(grid,k-1,m,n,p,q, memo);
//                        if(teleportation != Integer.MAX_VALUE)
//                            ans = Math.min(ans, teleportation);
//                    }
//                }
//            }
//        }
//        return memo[i][j][k]=ans;
//    }


}
