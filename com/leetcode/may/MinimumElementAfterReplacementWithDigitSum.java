package com.com.leetcode.may;

public class MinimumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        int [] nums = {10,12,13,14};
        int result = minElement(nums);
        System.out.println(result);
    }

    private static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            int sum = 0;
            while(num>0){
                sum += num%10;
                num /= 10;
            }
            min = Math.min(min,sum);
        }
        return min;
    }
}
