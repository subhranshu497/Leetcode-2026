package com.com.leetcode.nov;

public class MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int moves = minMovesII(nums);
        System.out.println(moves);
    }

    private static int minMovesII(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int x:nums){
            if(x < min)
                min = x;
        }
        long moves =0;
        for(int x :nums){
            moves += x-min;
        }
        return (int)moves;
    }
}
