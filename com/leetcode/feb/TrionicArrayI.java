package com.com.leetcode.feb;

public class TrionicArrayI {
    public static void main(String[] args) {
        int [] nums = {2,1,3};
        boolean flag = isTrionic(nums);
        System.out.println(flag);
    }

    private static boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        //check for increasing
        while(i+1 < n && nums[i]<nums[i+1])i++;
        if(i==0 || i==n-1)return false;
        while(i+1 < n && nums[i]>nums[i+1])i++;
        if(i==n-1)return false;
        while(i+1 < n && nums[i]<nums[i+1])i++;
        return i==n-1;
    }
}
