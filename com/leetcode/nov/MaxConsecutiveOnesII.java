package com.com.leetcode.nov;

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        int [] nums = {1,0,1,1,0};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int currCount =0;
        int prevCount =0;
        int maxCount = 0;
        for(int num:nums){
            if(num==1)currCount++;
            else{
                prevCount =currCount+1;
                currCount =0;
            }
            maxCount = Math.max(maxCount, currCount+prevCount);
        }
        return maxCount;
    }
}
