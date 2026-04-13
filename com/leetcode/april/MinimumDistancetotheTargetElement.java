package com.com.leetcode.april;

public class MinimumDistancetotheTargetElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int start = 0;
        int result = getMinDistance(arr, target, start);
        System.out.println(result); // Output the result
    }

    private static int getMinDistance(int[] arr, int target, int start) {
        int n = arr.length;
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==target)
            {
                minDist = Math.min(minDist,Math.abs(i-start));
            }
        }
        return minDist;
    }
}
