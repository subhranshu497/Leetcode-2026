package com.com.leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        int [] nums = {1,2,5,2,3};
        int target = 2;
        List<Integer> res = targetIndices(nums, target);
        System.out.println(res);
     }

    private static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)res.add(i);
            else if(nums[i]>target)break;
        }
        return res;
    }
}
