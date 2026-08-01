package com.com.leetcode.august;

import java.util.Arrays;

public class PredicttheWinner {
    private static int [][] t;
    public static void main(String[] args) {
        int [] nums = {1,5,20};
        boolean flag = predictTheWinner(nums);
        System.out.println(flag);
    }

    private static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        t = new int[n+1][n+1];
        for(int[] tArr:t)
            Arrays.fill(tArr,-1);
        int res = predictTheWinnerRecursion(nums, n,0,n-1);
        return res>=0;
    }

    private static int predictTheWinnerRecursion(int[] nums, int n, int i, int j) {
        //base case
        if(i==j){
            return nums[i];
        }
        if(t[i][j]!=-1)return t[i][j];
        //As per the game theory each player try to maximise their score and try to minimize oppent's score
        //since player one has the first turn , p1 try to make move to maximize its relative advantage
        //Player2 always make move to minimize p1's relative advantage
        //as per the qn player can start from either end
        //starting from leftand moving to right
        int moveRight = nums[i]-predictTheWinnerRecursion(nums,n,i+1,j);
        //starting from right and move left
        int moveLeft = nums[j]-predictTheWinnerRecursion(nums,n,i,j-1);
        return t[i][j]=Math.max(moveLeft, moveRight);

    }
}
