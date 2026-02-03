package com.com.leetcode.marathan.blind.seventyfive.partOne;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;

public class CombinationSumIV {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int target = 4;
        int sum = combinationSum4(nums, target);
        System.out.println(sum);
    }

    private static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int [] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return cumSum4Recursion(nums, n,target,0, memo);
    }

    private static int cumSum4Recursion(int[] nums, int n, int target, int sum, int [] memo) {
        //base case
        if(sum==target)return 1;
        if(sum>target) return 0;
        if(memo[sum] !=-1)return memo[sum];

        int ways =0;
        for(int i=0;i<n;i++)
            ways +=cumSum4Recursion(nums, n, target,sum+nums[i], memo);
        return memo[sum]=ways;
    }
}
