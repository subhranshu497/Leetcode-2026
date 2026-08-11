package com.com.leetcode.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static void main(String[] args) {
        int [] nums = {14,9,6,9,7,9,10,4,9,9,4,4};
        int missingNum = missingInteger(nums);
        System.out.println(missingNum);
    }

    private static int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        boolean isPrefix = true;
        for(int i=1;i<n;i++){
            if(isPrefix && nums[i-1]+1==nums[i]){
                sum +=nums[i];
            }else{
                isPrefix = false;
            }

            set.add(nums[i]);
        }
        while(set.contains(sum))sum++;

        return sum;
    }
}
