package com.com.leetcode.nov;

import java.util.List;

public class MinimumPositiveSumSubarray {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-2, 2, -3, 1);
        int l = 2, r = 3;
        int res = minimumSumSubarray(nums,l,r);
        System.out.println(res);
    }

    private static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum +=nums.get(j);
                int len = j-i+1;
                if(len>=l && len<=r && sum >0)
                    res = Math.min(res,sum);
                if(len>r)break;
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
