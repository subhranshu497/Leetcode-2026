package com.com.leetcode.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int [] nums = {4,2,3,1};
        List<List<Integer>> res = minimumAbsDifference(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> minimumAbsDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(nums[i+1]-nums[i]);
            minDiff = Math.min(diff, minDiff);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(nums[i+1]-nums[i]);
            if(diff==minDiff){
                res.add(Arrays.asList(nums[i],nums[i+1]));
            }
        }
        return res;
    }
}
