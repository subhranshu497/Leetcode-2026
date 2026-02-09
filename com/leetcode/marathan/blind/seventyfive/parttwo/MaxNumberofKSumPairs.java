package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;

public class MaxNumberofKSumPairs {
    public static void main(String[] args) {
        int [] nums = {3,1,3,4,3};
        int k = 6;
        int ops = maxOperations(nums, k);
        System.out.println(ops);
    }

    private static int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ops = 0;
        int i =0, j=n-1;
        while (i<j){
            int sum = nums[i]+nums[j];
            if(sum>k)j--;
            else if(sum <k)i++;
            else{
                ops++;
                i++;
                j--;
            }
        }
        return ops;
    }
}
