package com.com.leetcode.may;

import java.util.Arrays;

public class MaximumNumberofJumpstoReachtheLastIndex {
    public static void main(String[] args) {
        int [] nums = {1,3,6,4,1,2};
        int target =0;
        int jumps = maximumJumps(nums, target);
        System.out.println(jumps);
    }

    private static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0; //starting point, no jumps needed
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}
