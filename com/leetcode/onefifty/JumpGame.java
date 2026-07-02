package com.com.leetcode.onefifty;

import java.util.Arrays;

public class JumpGame {
    private static int[] memo;
    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
        boolean flag = canJumpOne(nums);
        System.out.println(flag);
    }


    private static boolean canJumpOne(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>maxReach) return false;
            maxReach = Math.max(i+nums[i], maxReach);
            if(maxReach >=n-1)return true;
        }
        return false;
    }


//    private static boolean canJumpOne(int[] nums) {
//        int n = nums.length;
//        memo = new int[n+1];
//        Arrays.fill(memo,-1);
//        if(n==1 && nums[0]==0)return true;
//        boolean flag = canJumpSolve(nums, n,0);
//        return flag;
//    }
//
//    private static boolean canJumpSolve(int[] nums, int n, int i) {
//        //base case
//        if(i>=n-1){
//            memo[i] = 1;
//            return true;
//        }
//        if(nums[i]==0){
//            memo[i] =0;
//            return false;
//        }
//        if(memo[i] !=-1) return memo[i]==1?true:false;
//        //start jumping
//        boolean flag= false;
//        for(int idx =1;idx<=nums[i];idx++){
//            if(flag){
//                memo[i] = 1;
//                return true;
//            }
//            flag = canJumpSolve(nums,n,i+idx);
//        }
//        memo[i]= flag==false?0:1;
//        return flag;
//    }
}
