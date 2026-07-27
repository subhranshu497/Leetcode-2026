package com.com.leetcode.july;

public class MaximumProductofTwoElementsinanArray {
    public static void main(String[] args) {
        int [] nums = {3,4,5,2};
        int res = maxProductII(nums);
        System.out.println(res);
    }

    private static int maxProductII(int[] nums) {
        int n = nums.length;
        int first =-1;
        int second =-1;
        for(int num:nums){
            if(num>first){
                second = first;
                first = num;
            }else if(num > second){
                second = num;
            }
        }
        return (first-1)*(second-1);
    }
}
