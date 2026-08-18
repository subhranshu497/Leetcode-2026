package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class FindtheLargestAlmostMissingInteger {
    public static void main(String[] args) {
        int [] nums = {0,0};
        int k = 1;
        int res = largestInteger(nums,k);
        System.out.println(res);
    }

    private static int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
            max = Math.max(max, num);
        }
        // k == n: only one window exists, so every value qualifies.
        if(k==n) return max;
        if(k==1){
            int res = -1;
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                if(e.getValue()==1) res = Math.max(res, e.getKey());
            }
            return res;
        }
        boolean valid0 = map.get(nums[0])==1;
        boolean valid1 = map.get(nums[n-1])==1;
        if(valid0 && valid1) return Math.max(nums[0], nums[n-1]);
        if(valid0) return nums[0];
        if(valid1) return nums[n-1];
        return -1;
    }
}
