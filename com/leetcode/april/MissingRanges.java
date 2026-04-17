package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {-1};
        int lower = -1;
        int upper = -1;
        List<List<Integer>> res = findMissingRanges(nums, lower, upper);
        System.out.println(res);
    }

    private static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> missingRanges = new ArrayList<>();
        if (n == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }
        if(lower < nums[0])
            missingRanges.add(Arrays.asList(lower, nums[0]-1));
        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1]) continue;
            int l_bound = nums[i]+1;
            int u_bound = nums[i+1]-1;
            missingRanges.add(List.of(l_bound, u_bound));
        }
        if(nums[n-1]<upper){
            missingRanges.add(List.of(nums[n-1]+1, upper));
        }
        return missingRanges;
    }
}
