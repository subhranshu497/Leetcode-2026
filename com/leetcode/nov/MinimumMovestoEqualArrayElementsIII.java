package com.com.leetcode.nov;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsIII {
    public static void main(String[] args) {
        int [] nums = {4,4,5};
        int moves = minMovesIII(nums);
        System.out.println(moves);
    }

    private static int minMovesIII(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int moves =0;
        for(int i=0;i<n;i++){
            moves +=nums[n-1]-nums[i];
        }
        return moves;
    }
}
