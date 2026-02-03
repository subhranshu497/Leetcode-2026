package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS(nums);
        System.out.println(len);
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prev = -1;
        int [][] memo = new int[n+1][n];
        for(int[] me:memo)
            Arrays.fill(me, -1);
        return lcsRec(nums, n,0,prev, memo);
    }

    private static int lcsRec(int[] nums, int n, int i, int prev, int [][] memo) {
        //base case
        if(i>=n) return 0;
        if(memo[i][prev+1] !=-1)return memo[i][prev+1];
//skip
        int skip = lcsRec(nums, n, i+1, prev, memo);
        //take
        int take = 0;
        if(prev==-1 || nums[prev] < nums[i]){
            take = 1+ lcsRec(nums, n,i+1,i, memo);
        }
        return memo[i][prev+1]=Math.max(skip, take);
    }

//    private static int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int [] dp = new int[n+1];
//        Arrays.fill(dp,1);
//        int lis = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<i;j++){
//                if(nums[i]>nums[j]){
//                    dp[i] = Math.max(dp[i], 1+dp[j]);
//                    lis = Math.max(lis, dp[i]);
//                }
//            }
//        }
//        return lis;
//    }
}
