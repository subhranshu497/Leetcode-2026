package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class LongestSubarrayofOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        int [] nums = {1,1,1};
        int res =longestSubarray(nums);
        System.out.println(res);
    }

    private static int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int zeroCount =0;
        while(right<n){
            if(nums[right]==0)zeroCount++;
            while(zeroCount >1){
                if(nums[left]==0)zeroCount--;
                left++;
            }
            maxCount = Math.max(maxCount, right-left);
            right++;
        }
        return maxCount;
    }
}
