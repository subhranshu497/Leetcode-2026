package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        int count = longestConsecutive(nums);
        System.out.println(count);
    }

    private static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int maxCount = Integer.MIN_VALUE;
        for(int num:set){
            int currNum = num;
            if(!set.contains(currNum-1)){
                int currCount =1;
                while(set.contains(currNum+1)){
                    currCount +=1;
                    currNum = currNum+1;
                }
                maxCount = Math.max(maxCount, currCount);
            }
        }
        return maxCount;
    }
}
