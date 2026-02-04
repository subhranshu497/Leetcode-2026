package com.com.leetcode.feb;

import java.util.Arrays;

public class TrionicArrayII {
    private static long minVal = Long.MIN_VALUE/2;
    public static void main(String[] args) {
          int [] nums = {-624,352,29,558,790,-932,867,-387,318,966,-965,291,433,924};
        long res = maxSumTrionic(nums);
        System.out.println(res);
    }

    private static long maxSumTrionic(int[] nums) {
        int n= nums.length;
        //four patterns
        //pattern 0 - no pattern
        //pattern - 1 - increasing
        //pattern 2 - decreasing
        //patern -3 - increasing
        long [][] memo = new long[n+1][4];
        for(long[] arr:memo)
            Arrays.fill(arr, Long.MIN_VALUE);
        return maxTritonicSolve(nums,n,0,0, memo);
    }

    private static long maxTritonicSolve(int[] nums, int n, int i, int pattern, long[][]memo) {
        //at starting we have option to take the first element or skip
        //the reason for skipping is , if it is -ve value and contributes -vely in the maxsum
        //before starting pattern 1 , check if there is no parrern running i.e pattern =0
        if(i==n) return (pattern==3)?0:minVal;
        if(memo[i][pattern] != Long.MIN_VALUE) return memo[i][pattern];
        long take = minVal;
        long skip =minVal;
        if(pattern==0)
            skip = maxTritonicSolve(nums,n,i+1,0, memo);
        if(pattern==3)
            take = nums[i];
        if(i<n-1){
            int curr = nums[i];
            int next = nums[i+1];
            if(pattern==0 && curr < next){
                take = Math.max(take,curr+maxTritonicSolve(nums,n,i+1,1, memo));
            }
            else if(pattern==1){
                if(curr < next)
                    take = Math.max(take, curr+maxTritonicSolve(nums,n,i+1,1, memo));
                else if(curr>next){
                    take = Math.max(take, curr+maxTritonicSolve(nums,n,i+1,2, memo));
                }
            }
            //once the pattern is started , there is no chance of skip, because it will break the pattern
            else if(pattern==2){
                if(curr>next)
                    take = Math.max(take, curr+maxTritonicSolve(nums,n,i+1,2, memo));
                else if(curr<next){
                    take = Math.max(take,curr+maxTritonicSolve(nums,n,i+1,3, memo));
                }
            }else if(pattern==3 && curr<next){
                take = Math.max(take,curr+maxTritonicSolve(nums,n,i+1,3, memo));
            }
        }
                return memo[i][pattern]=Math.max(take, skip);
    }
}
