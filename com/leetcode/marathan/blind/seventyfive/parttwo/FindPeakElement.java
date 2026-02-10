package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class FindPeakElement {
    public static void main(String[] args) {
        int [] nums = {1,2};
        int idx = findPeakElement(nums);
        System.out.println(idx);
    }

    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        if(n==1)return 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            int num = nums[mid];
            boolean left = (mid==0)|| (num>nums[mid-1]);
            boolean right = (mid==n-1) || (num >nums[mid+1]);
            if(left && right) return mid;
            else if(num < nums[mid+1]) l = mid+1;
            else if(num < nums[mid-1]) r= mid-1;
        }
        return -1;
    }
}
