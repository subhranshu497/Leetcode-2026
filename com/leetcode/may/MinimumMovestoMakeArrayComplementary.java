package com.com.leetcode.may;

public class MinimumMovestoMakeArrayComplementary {
    public static void main(String[] args) {
        int [] nums = {1,2,1,2};
        int limit = 2;
        int moves = minMoves(nums, limit);
        System.out.println(moves);
    }

    private static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int minimumMove = Integer.MAX_VALUE;
       int [] diffArr = new int[(2*limit)+2];

       for(int i=0;i<n/2;i++){
           diffArr[2] +=2;
           diffArr[(2*limit)+1] -=2;
           int a = nums[i];
           int b = nums[n-1-i];

           int minVal = Math.min(a,b)+1;
           int maxVal = Math.max(a,b)+limit;

           diffArr[minVal] -=1;
           diffArr[maxVal+1] +=1;

           diffArr[a+b] -=1;
           diffArr[a+b+1] +=1;
       }
       minimumMove =n;
       //find the cumsum
        for(int i=2;i< 2*limit;i++){
            diffArr[i] += diffArr[i-1];
            minimumMove = Math.min(minimumMove,diffArr[i]);
        }
        return minimumMove;
    }
}
