package com.com.leetcode.may;

public class CheckifArrayIsSortedandRotated {
    public static void main(String[] args) {
        int [] nums = {2,1,3,4};
        boolean isSortedAndRotated = checkI(nums);
        System.out.println(isSortedAndRotated);
    }

    private static boolean checkI(int[] nums) {
        int n = nums.length;
        //take a counter to count the number of times the order is broken
        int count = 0;
        if(nums[0] < nums[n-1]) count++;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]) count++;
        }
        System.out.println(count);
        return count<=1;
    }
}
