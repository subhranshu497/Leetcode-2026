package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        int prod = maxProduct(nums);
        System.out.println(prod);
    }

    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for(int i=1;i<n;i++){
            int num = nums[i];
            if(num < 0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(num, currMax*num);
            currMin = Math.min(num, currMin*num);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
