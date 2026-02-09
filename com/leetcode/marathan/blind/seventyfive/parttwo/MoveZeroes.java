package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MoveZeroes {
    public static void main(String[] args) {
        int [] nums = {0,0};
        moveZeroes(nums);
        for(int num:nums)
            System.out.print(num+", ");
    }

    private static void moveZeroes(int[] nums) {
        int n = nums.length;
        int write =0;
        //first fill all the non zeros at the front of the array
        for(int read=0;read <n;read++){
            if(nums[read] != 0){
                nums[write] = nums[read];
                write++;
            }
        }
        while(write <n){
            nums[write] = 0;
            write++;
        }
    }
}
