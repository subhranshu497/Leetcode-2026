package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int money = rob(nums);
        System.out.println(money);
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=n;i++){
            int take = dp[i-2]+nums[i-1];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }


//    private static int robSolve(int[] nums, int n, int i, int[] memo) {
//        //base case
//        if(i>=n) return 0;
//        if(memo[i] !=-1) return memo[i];
//        int take = nums[i]+robSolve(nums, n,i+2, memo);
//        int skip = robSolve(nums, n,i+1, memo);
//        return memo[i] =Math.max(take, skip);
//    }
}
