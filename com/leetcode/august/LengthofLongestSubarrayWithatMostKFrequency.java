package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestSubarrayWithatMostKFrequency {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3,1,2};
        int k =2;
        int len = maxSubarrayLength(nums,k);
        System.out.println(len);
    }

    private static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans =0;
        int l=0;
        int r =0;
        Map<Integer, Integer> map = new HashMap<>();
        while(l<n && r <n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r])>k){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
