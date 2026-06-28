package com.com.leetcode.june;

import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {
    public static void main(String[] args) {
        int [] arr = {100,1,1000};
        int res = maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(res);
    }

    private static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if(arr[0] !=1)arr[0]=1;
        int maxNum = arr[0];
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(arr[i]-arr[i+1]);
            if(diff >=1){
                arr[i+1]=arr[i]+1;
                maxNum = arr[i+1];
            }
        }
        return maxNum;
    }
}
