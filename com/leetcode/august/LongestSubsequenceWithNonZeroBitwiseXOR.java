package com.com.leetcode.august;

import java.util.Arrays;

public class LongestSubsequenceWithNonZeroBitwiseXOR {
    private static int min = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int len = longestSubsequence(nums);
        System.out.println(len);
    }

    private static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int res = nums[0]!=0?nums[0]:0;
        boolean allZeros = Arrays.stream(nums).allMatch(x->x==0);
        if(allZeros)return 0;
        for(int i=1;i<n;i++){
            res ^= nums[i];
        }
        return res !=0 ?n:n-1;
    }

//    private static int longestSubsequence(int[] nums) {
//        int n = nums.length;
//        int res = formSubsequenceCheckXor(nums, n, 1, nums[0]);
//        return res==min?0:res+1;
//    }
//
//    private static int formSubsequenceCheckXor(int[] nums, int n, int i, int prevXor) {
//        //base case
//        if(i==n)return prevXor !=0?0:min;
//
//        int lastVal = nums[i]^prevXor;
//        //take
//        int take =formSubsequenceCheckXor(nums,n,i+1,lastVal);
//        if(take != min)take +=1;
//        //skip
//        int skip = formSubsequenceCheckXor(nums, n, i+1, prevXor);
//        return Math.max(take, skip);
//    }
}
