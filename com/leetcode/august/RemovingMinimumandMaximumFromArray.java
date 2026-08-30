package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class RemovingMinimumandMaximumFromArray {
    public static void main(String[] args) {
        int [] nums = {-14,61,29,-18,59,13,-67,-16,55,-57,7,74};
        int count = minimumDeletionsI(nums);
        System.out.println(count);
    }

    private static int minimumDeletionsI(int[] nums) {
        int n = nums.length;
        //find minimum nd maximum
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        //find the indexes of min and max
        int minIdx = map.get(min);
        int maxIdx = map.get(max);
        // Find left-most and right-most target indices
        int first = Math.min(minIdx, maxIdx);
        int second = Math.max(minIdx, maxIdx);

        // Option 1: Delete both from the left
        int option1 = second + 1;

        // Option 2: Delete both from the right
        int option2 = n - first;

        // Option 3: Delete one from left, one from right
        int option3 = (first + 1) + (n - second);

        return Math.min(option1, Math.min(option2, option3));
    }
}
