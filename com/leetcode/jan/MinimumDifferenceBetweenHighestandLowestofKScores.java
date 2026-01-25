package com.com.leetcode.jan;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumDifferenceBetweenHighestandLowestofKScores {
    public static void main(String[] args) {
        int [] nums = {9,4,1,7};
        int k = 2;
        int res = minimumDifference(nums, k );
        System.out.println(res);
    }

    private static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = l+k-1;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        if(n==1) return 0;
        while (l<n && r<n){
            int lowestScore = nums[l];
            int highestScore = nums[r];
            diff = Math.min(diff, highestScore-lowestScore);
            l++;
            r++;
        }
        return diff;
    }
}
