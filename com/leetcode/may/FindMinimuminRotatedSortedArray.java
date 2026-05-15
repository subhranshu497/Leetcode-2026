package com.com.leetcode.may;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {0,1,2,4,5,6,7};
        int min = findMinI(nums);
        System.out.println(min);
    }

    private static int findMinI(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l = mid+1;
            }else
                r = mid-1;
            min = Math.min(min,nums[mid]);
        }
        return min;
    }
}
