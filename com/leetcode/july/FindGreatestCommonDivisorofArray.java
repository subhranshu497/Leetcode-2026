package com.com.leetcode.july;

public class FindGreatestCommonDivisorofArray {
    public static void main(String[] args) {
        int [] nums = {2,5,6,9,10};
        int res = findGCD(nums);
        System.out.println(res);
    }

    private static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return gcdHelper(min,max);
    }
    private static int gcdHelper(int a, int b){
        if(b==0)return a;
        return gcdHelper(b, a%b);
    }
}
