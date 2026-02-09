package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int ans = longestOnes(nums, k);
        System.out.println(ans);
    }
    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        int maxCount = 0;
        int zeroCount = 0;
        //we will track the count of zero , as based on the zero count we need to shrink the window
        while (right<n && left<n){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount >k){
                if(nums[left]==0){
                    zeroCount --;
                }
                left++;
            }
            maxCount = Math.max(maxCount, right-left+1);
            right++;
        }
        return maxCount;
    }
}
