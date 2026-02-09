package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double avg = findMaxAverage(nums,k);
        System.out.println(avg);
    }

    private static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        while (right <n){
            while(right-left+1 <=k){
                sum +=nums[right];
                right++;
            }
            maxSum = Math.max(maxSum, sum);
            sum -=nums[left];
            left++;
        }
        return (double) maxSum/k;
    }
}
