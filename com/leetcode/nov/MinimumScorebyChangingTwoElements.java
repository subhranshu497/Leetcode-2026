package com.com.leetcode.nov;

import java.util.Arrays;

public class MinimumScorebyChangingTwoElements {
    public static void main(String[] args) {
        int [] nums = {1,4,7,8,5};
        int res = minimizeSum(nums);
        System.out.println(res);
    }

    private static int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        //since we are allowed to change 2 elements , so pick 3 smallest and 3 largest value
        int [] largestAr = {nums[n-1], nums[n-2], nums[n-3]};
        int [] smallestArr = {nums[0], nums[1],nums[2]};
        //option 1 = pick two largest value of the largestarr to be changed
        int sum1 = Math.abs(largestAr[2]-smallestArr[0]);
        //option 2 = pick two smallest value of the smallest to be changed
        int sum2 = Math.abs(smallestArr[2]-largestAr[0]);
        //option 3 = pick one from each to be changed
        int sum3 = Math.abs(largestAr[1]-smallestArr[1]);

        return Math.min(sum1,Math.min(sum2,sum3));
    }
}
