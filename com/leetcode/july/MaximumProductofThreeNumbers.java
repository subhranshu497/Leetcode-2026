package com.com.leetcode.july;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int res = maximumProduct(nums);
        System.out.println(res);
    }

    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res1 = nums[0]*nums[1]*nums[n-1];
        int res2 = nums[n-1]*nums[n-2]*nums[n-3];
        return res1>res2?res1:res2;
    }
}
