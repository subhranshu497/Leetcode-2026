package com.com.leetcode.may;

public class FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        int [] nums = {3,1,1};
        int res = findMinII(nums);
        System.out.println(res);
    }

    private static int findMinII(int[] nums) {
        int n = nums.length;
        int  l =0 , r = n-1;
        int minIdx =0;
        while(l<=r){
            //if duplicate found shrink the l and r
            while (l+1<n && nums[l]==nums[l+1]){
                l++;
            }
            while (r-1>=0 && nums[r]==nums[r-1]){
                r--;
            }
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[minIdx])
                minIdx = mid;
            if(nums[mid]>nums[r]){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return nums[minIdx];
    }
}
