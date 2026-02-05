package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3};
        boolean flag = increasingTriplet(nums);
        System.out.println(flag);
    }

    private static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int i =0;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
       //check for first increment
        while(i<n){
            if(nums[i]<=num1){
                num1 = nums[i];
            }else if(nums[i]<=num2){
                num2 = nums[i];
            }else return true;
            i++;
        }
        return false;
    }
}
