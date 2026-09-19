package com.com.leetcode.sept;

import java.util.Arrays;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public static void main(String[] args) {
        int [] arr = {3,2,2,4,3};
        int target =3;
        int res = minSumOfLengths(arr, target);
        System.out.println(res);
    }

    private static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int [] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        int l =0, sum =0;
        int minCombinedLen =Integer.MAX_VALUE;
        int currMinLen = Integer.MAX_VALUE;
        int r =0;
        while (r<n){
            while (sum>target){
                sum -=arr[l];
                l++;
            }
            if(sum==target){
                int len = r-l+1;
                if(l>0 && minLen[l-1] !=Integer.MAX_VALUE){
                    minCombinedLen = Math.min(minCombinedLen, len+minLen[l-1]);
                }
                currMinLen = Math.min(currMinLen,len);
            }
            if (r > 0) {
                minLen[r] = Math.min(minLen[r - 1], currMinLen);
            } else {
                minLen[r] = currMinLen;
            }
            r++;
        }
        return minCombinedLen == Integer.MAX_VALUE ? -1 : minCombinedLen;
    }
}
