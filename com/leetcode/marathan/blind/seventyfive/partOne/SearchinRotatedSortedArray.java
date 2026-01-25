package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int idx = searchI(nums, target);
        System.out.println(idx);
    }

    private static int searchI(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l] <= nums[mid]){
                if(nums[l]<=target && target < nums[mid]) h=mid-1;
                else l =mid+1;
            }
            else{
                if(nums[mid]<target && target <= nums[h]) l=mid+1;
                else h =mid-1;
            }
        }
        return -1;
    }
}
