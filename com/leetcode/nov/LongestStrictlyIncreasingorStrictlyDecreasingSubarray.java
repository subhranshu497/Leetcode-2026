package com.com.leetcode.nov;

import java.util.Arrays;

public class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {
    public static void main(String[] args) {
        int [] nums = {1,4,3,3,2};
        //                      2,2
        int len = longestMonotonicSubarray(nums);
        System.out.println(len);
    }

    private static int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLen = 1;
        int incLen = 1;
        int decLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1; // Reset decreasing streak
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1; // Reset increasing streak
            } else {
                // If elements are equal, strict monotonicity is broken
                incLen = 1;
                decLen = 1;
            }

            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}
