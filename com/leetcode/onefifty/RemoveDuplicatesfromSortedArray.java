package com.com.leetcode.onefifty;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int dups = removeDuplicatesI(nums);
        System.out.println(dups);
    }

    private static int removeDuplicatesI(int[] nums) {
        int n= nums.length;
        int i=0;
        int j=0;
        while (j<n){
            if(nums[i] !=nums[j]){
                nums[i+1]= nums[j];
                i = i+1;
            }
            j++;
        }
        return i+1;
    }
}
