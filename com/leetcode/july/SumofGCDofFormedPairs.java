package com.com.leetcode.july;

import java.util.Arrays;

public class SumofGCDofFormedPairs {
    public static void main(String[] args) {
        int [] nums = {2,6,4};
        long res = gcdSum(nums);
        System.out.println(res);
    }

    private static long gcdSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        //iterate and calculate the gcd of num with the max so far
        int max =-1;
        int [] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]> max) max = nums[i];
            prefixGcd[i] = gcdI(max,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int i=0, j=n-1;
        while(i<j){
            sum+=gcdI(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }

    private static int gcdI(int a, int b) {
        if(b==0)return a;
        return gcdI(b,a%b);
    }
}
