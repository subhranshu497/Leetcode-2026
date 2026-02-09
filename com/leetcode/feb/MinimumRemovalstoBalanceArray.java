package com.com.leetcode.feb;

import java.util.Arrays;
import java.util.Map;

public class MinimumRemovalstoBalanceArray {
    public static void main(String[] args) {
        int [] nums = {2,1,5};
        int k = 2;
        int count = minRemoval(nums,k);
        System.out.println(count);
    }

    private static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int r = 0;
        int l =0;
        int removal = Integer.MIN_VALUE;
        while(r<n){
            //shrink the window
            while ((long)nums[r]>(long)nums[l]*k){
                l++;
            }
            removal = Math.max(removal, r-l+1);
            r++;
        }
        return n-removal;
    }
}
