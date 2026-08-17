package com.com.practice.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        int lis = lengthOfLISIIRec(nums);
        System.out.println(lis);
    }

    private static int lengthOfLISIIRec(int[] nums) {
        int n = nums.length;
        int [][] memo = new int[n+1][n+1];
        for(int[] m:memo)
            Arrays.fill(m,-1);
        return lisRecursion(nums, n, 0, -1, memo);
    }

    private static int lisRecursion(int[] nums, int n, int i, int prev, int[][] memo) {
        //base case
        if(i>=n)return 0;
        if(memo[i][prev+1] !=-1)return memo[i][prev+1];
        //take
        int take =0;
        if(prev ==-1 || nums[prev]<nums[i]){
            take = 1+lisRecursion(nums,n,i+1, i, memo);
        }
        //skip
        int skip = lisRecursion(nums,n,i+1, prev, memo);
        return memo[i][prev+1]=Math.max(take, skip);
    }

//    private static int lengthOfLISII(int[] nums) {
//        int n = nums.length;
//        int [] dp = new int[n+1];
//        Arrays.fill(dp, 1);
//        for(int i=1;i<n;i++){
//            for(int j =0;j<i;j++){
//                //start comparsion
//                if(nums[j]<nums[i]){
//                    dp[i] = Math.max(dp[i], 1+dp[j]);
//                }
//            }
//        }
//        int lis = 0;
//        for(int d:dp)
//            lis= Math.max(d, lis);
//        return lis;
//    }
}
