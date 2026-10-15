package com.com.leetcode.oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumofSquaresI {
    public static void main(String[] args) {
        int [] nums = {1,2,1};
        int sum = sumCounts(nums);
        System.out.println(sum);
    }

    private static int sumCounts(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctSet.add(nums[j]);
                int distinctCount = distinctSet.size();
                totalSum += distinctCount * distinctCount;
            }
        }
        return totalSum;
    }
}
