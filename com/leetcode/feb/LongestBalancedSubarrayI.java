package com.com.leetcode.feb;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestBalancedSubarrayI {
    public static void main(String[] args) {
        int [] nums = {2,5,4,3};
        int count = longestBalanced(nums);
        System.out.println(count);
    }

    private static int longestBalanced(int[] nums) {
        int res = 0;
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0)evenSet.add(nums[j]);
                else oddSet.add(nums[j]);
                if(evenSet.size()==oddSet.size())
                    res = Math.max(res, j-i+1);
            }
            evenSet.clear();
            oddSet.clear();
        }
        return res;
    }
}
