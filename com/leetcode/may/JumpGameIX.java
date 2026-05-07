package com.com.leetcode.may;

import java.util.Arrays;

public class JumpGameIX {
    public static void main(String[] args) {
        int [] nums = {2,3,1};
        int [] res = maxValueI(nums);
        for(int i: res){
            System.out.print(i+" ");
        }
    }

    private static int[] maxValueI(int[] nums) {
        int n = nums.length;
        //find left max and save in an array , as in case of moving forward the remaining elements should be smaller than he curr one
        int [] leftMax = new int[n];
        for(int i=0;i<n;i++){
            leftMax[i] = i==0? nums[i]: Math.max(nums[i], leftMax[i-1]);
        }
        //find the right min and save in an array, as in case of moving backward the remaining elements should be greater than the curr one
        int [] rightMin = new int[n];
        for(int i=n-1;i>=0;i--){
            rightMin[i] = i==n-1? nums[i]: Math.min(nums[i], rightMin[i+1]);
        }
        int [] res = new int[n];
        //jump is possible if leftmax of i > rightmin of i+1
        for(int i=n-1;i>=0;i--){
            if(i==n-1) {
                res[i] = leftMax[n - 1];
            }
            else if(leftMax[i] > rightMin[i+1]){
                res[i] = res[i+1];
            }
            else{
                res[i] = leftMax[i];
            }
        }
        return res;
    }
}
