package com.com.leetcode.feb;

public class DivideanArrayIntoSubarraysWithMinimumCostI {
    public static void main(String[] args) {
        int [] nums = {1,2,3,12};
        int cost = minimumCostI(nums);
        System.out.println(cost);
    }

    private static int minimumCostI(int[] nums) {
        int n = nums.length;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int res = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            }else if(nums[i]<secondMin)
                secondMin = nums[i];
        }
        res +=firstMin+secondMin;
        return res;
    }
}
