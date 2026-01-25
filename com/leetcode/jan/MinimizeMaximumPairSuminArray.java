package com.com.leetcode.jan;

import java.util.Arrays;

public class MinimizeMaximumPairSuminArray {
    public static void main(String[] args) {
        int [] nums = {3,5,4,2,4,6};
        int sum = minPairSum(nums);
        System.out.println(sum);
    }

    private static int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j= n-1;
        int sum = 0;
        while(i<j){
            sum = Math.max(sum, nums[i]+nums[j]);
            i++;
            j--;
        }
        return sum;
    }
}
