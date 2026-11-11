package com.com.leetcode.nov;

import java.util.Arrays;
import java.util.Map;

public class ClimbingStairsII {
    private static int [] t;
    public static void main(String[] args) {
        int n =4;
        int [] costs = {1,2,3,4};
        int ans = climbStairsIIDP(n, costs);
        System.out.println(ans);
    }

    private static int climbStairsIIDP(int n, int[] costs) {
        int [] dp = new int[n+1];
       for(int i=n-1;i>=0;i--){
           int cost =Integer.MAX_VALUE;
           int j =i+1;
           if(j<=n) cost = Math.min(cost, costs[j-1]+(int)Math.pow(j-i,2)+dp[j]);
           j =i+2;

           if(j<=n) cost = Math.min(cost, costs[j-1]+(int)Math.pow(j-i,2)+dp[j]);
           j =i+3;
           if(j<=n) cost = Math.min(cost, costs[j-1]+(int)Math.pow(j-i,2)+dp[j]);
           dp[i] =cost;
       }
       return dp[0];
    }

    private static int climbStairsII(int n, int[] costs) {
        t = new int[n+1];
        Arrays.fill(t,-1);
        int ans = climbStairsSolveII(n, costs,0);
        return ans;
    }

    private static int climbStairsSolveII(int n, int[] costs, int i) {
        //base case
        if(i==n)return 0;
        if(t[i]!=-1) return t[i];
        int j =i+1;
        int cost =Integer.MAX_VALUE;
        if(j<=n){
            cost = Math.min(cost,costs[j-1]+(int)Math.pow(j-i,2)+climbStairsSolveII(n,costs,j));
        }
        j =i+2;
        if(j<=n){
            cost = Math.min(cost,costs[j-1]+(int)Math.pow(j-i,2)+climbStairsSolveII(n,costs,j));
        }
        j =i+3;
        if(j<=n){
            cost = Math.min(cost,costs[j-1]+(int)Math.pow(j-i,2)+climbStairsSolveII(n,costs,j));
        }
        return t[i]=cost;
    }
}
