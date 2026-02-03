package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int money = robII(nums);
        System.out.println(money);
    }

    private static int robII(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        //option 1 - 0 to n-2
        int money1 = robIIDP(nums, 0, n-2);
        int money2 = robIIDP(nums, 1, n-1);
        return Math.max(money1, money2);
    }

    private static int robIIDP(int[] nums, int st, int n) {
        int len = n-st+1;
        int [] dp = new int[len+1];
        if(n<=0)return 0;
        dp[0] = 0;
        dp[1] = nums[st];
        for(int i = 2;i<=len;i++){
            int take = dp[i-2]+nums[st+i-1];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[len];
    }

//    private static int robII(int[] nums) {
//        int n = nums.length;
//        if(n==1)return nums[0];
//        int [] memo = new int[n+1];
//        Arrays.fill(memo, -1);
//        //since houses are in circular manner
//        // option 1 - i will take houses from 0 to n-2
//        //option 2 - 1 to n-1
//        //then maximize the result
//        int money1 = robIISolve(nums, 0,n-2, memo);
//        memo = new int[n+1];
//        Arrays.fill(memo, -1);
//        int money2 = robIISolve(nums, 1,n-1, memo);
//
//        return Math.max(money1,money2);
//    }
//
//    private static int robIISolve(int[] nums, int st, int end, int[] memo) {
//        if(st>end) return 0;
//        if(memo[st] !=-1) return memo[st];
//        int take = nums[st]+robIISolve(nums, st+2,end,memo);
//        int skip = robIISolve(nums,st+1, end, memo);
//        return memo[st] = Math.max(take, skip);
//    }
}
