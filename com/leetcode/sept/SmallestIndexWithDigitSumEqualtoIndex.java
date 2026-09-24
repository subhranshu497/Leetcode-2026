package com.com.leetcode.sept;

public class SmallestIndexWithDigitSumEqualtoIndex {
    public static void main(String[] args) {
        int [] nums = {1,3,2};
        int idx = smallestIndex(nums);
        System.out.println(idx);
    }

    private static int smallestIndex(int[] nums) {
        int n =nums.length;
        int i=0;
        for(int num:nums){
            int sum =0;
            while(num>0){
                int rem = num%10;
                sum +=rem;
                num /=10;
            }
            if(sum==i)return i;
            i++;
        }
        return -1;
    }
}
