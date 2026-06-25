package com.com.leetcode.june;

public class CountSubarraysWithMajorityElementI {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3};
        int target = 2;
        int res = countMajoritySubarrays(nums,target);
        System.out.println(res);
    }

    private static int countMajoritySubarrays(int[] nums, int target) {
        int n =nums.length;
        int count =0;
        //int targetCount=0;
        for(int i=0;i<n;i++){
            int len =0;
            int targetCount=0;
            for(int j=i;j<n;j++){
                len +=1;
                int half = len/2;
                if(nums[j]==target)
                    targetCount +=1;
                if(targetCount>half)count++;
            }
        }
        return count;
    }
}
