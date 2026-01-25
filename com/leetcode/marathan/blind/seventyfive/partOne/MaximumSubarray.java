package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Map;

public class MaximumSubarray {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }

    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            max= Math.max(currSum, max);
        }
        return max;
    }
}
