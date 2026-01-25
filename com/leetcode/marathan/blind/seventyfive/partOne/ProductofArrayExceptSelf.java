package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] res = productExceptSelf(nums);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightToLeft = new int[n];
        Arrays.fill(rightToLeft, 1);
        int[] lefttoRight = new int[n];
        Arrays.fill(lefttoRight, 1);
        for(int i =0;i<n;i++) lefttoRight[i] = (i==0)?nums[i]:nums[i]*lefttoRight[i-1];
        for(int i =n-1;i>=0;i--) rightToLeft[i] = (i==n-1)?nums[i]:nums[i]*rightToLeft[i+1];
        int [] ans = new int[n];
        for(int i = 0;i<n;i++) ans[i]= ((i-1) < 0?1:lefttoRight[i-1])*(i+1==n?1:rightToLeft[i+1]);
        return ans;
    }
}
