package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int [] nums = {2,5,0,0};
        System.out.println(canJump(nums));
     }

    private static boolean canJump(int[] nums) {
        int n= nums.length;
        boolean [] t = new boolean[n];
        t[0] = true; // it is given in the question that , i am at starting
        for(int i=1;i<n;i++){
            for(int j =i-1;j>=0;j--){
                int steps = j+nums[j];
                if(t[j] && steps>=i){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n-1];
    }

//    private static boolean canJump(int[] nums) {
//        int n = nums.length;
//        Boolean [] memo = new Boolean[n+1];
//        return canJumpSolve(nums, n, 0, memo);
//    }
//
//    private static boolean canJumpSolve(int[] nums, int n, int i, Boolean [] memo) {
//        //base case
//        if(i>=n-1)return true;
//        if(nums[i]==0)return false;
//        if(memo[i] != null) return memo[i];
//        int maxSteps = nums[i];
//        for(int idx =1;idx<=Math.min(n-1,maxSteps);idx++)
//            if(canJumpSolve(nums,n,i+idx, memo)) return true;
//
//        return memo[i] =false;
//    }
}
