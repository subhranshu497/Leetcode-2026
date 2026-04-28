package com.com.leetcode.april;

import java.util.Arrays;

public class MinimumOperationstoMakeaUniValueGrid {
    public static void main(String[] args) {
        int [][] grid = {{2,4}, {6,8}};
        int x = 2;
        SolutionDay0428 solution = new SolutionDay0428();
        int minOperations = solution.minOperations(grid, x);
        System.out.println(minOperations);
    }
}
class SolutionDay0428{
    public int minOperations(int[][] grid, int x) {
        int [] nums = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .toArray();
        int n = nums.length;
        Arrays.sort(nums);
        int ops = 0;
        for(int i=0;i<n;i++){
            //the case when res is not possible
            if(Math.abs(nums[i]-nums[n/2])%x!=0) return -1;
            ops+=Math.abs(nums[i]-nums[n/2])/x;
        }
        return ops;
    }
}
