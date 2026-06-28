package com.com.leetcode.onefifty;

public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int res = removeDuplicatesII(nums);
        System.out.println(res);
    }

    private static int removeDuplicatesII(int[] nums) {
        int n = nums.length;
        int i =0;
        int j =0;
        int counter =0;
        while(j<n){
           if(i>0 && nums[i-1]==nums[j])counter++;
           else counter =1;
               if(counter<=2){
                   nums[i] = nums[j];
                   i++;
               }
           j++;
        }
        return i;
    }
}
