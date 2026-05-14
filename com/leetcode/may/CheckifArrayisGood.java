package com.com.leetcode.may;

import java.util.Arrays;

public class CheckifArrayisGood {
    public static void main(String[] args) {
        int [] nums = {3, 4, 4, 1, 2, 1};
        System.out.println(isGood(nums));
    }

    private static boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n==1) return false;
        if(nums[n-1] != nums[n-2])return false;
        if(nums[n-1] != n-1) return false;
        for(int i = 0;i<n-2;i++){
            if(nums[i] != i+1)return false;
        }
        return true;
    }
}
