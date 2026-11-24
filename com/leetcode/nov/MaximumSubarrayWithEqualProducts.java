package com.com.leetcode.nov;

public class MaximumSubarrayWithEqualProducts {
    public static void main(String[] args) {
        int [] nums = {2,3,4,5,6};
        int res = maxLength(nums);
        System.out.println(res);
    }

    public static int maxLength(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int l =0;l<n;l++){
            long g = nums[l], lc = nums[l];
            double inv = 1.0 /nums[l];
            for(int r=l;r<n;r++){
                if(r>l){
                    g = gcdOfTwoNum(g, nums[r]);
                    lc = lc / gcdOfTwoNum(lc, nums[r]) * nums[r];
                    inv /= nums[r];
                }
                if (g * (double) lc * inv > 0.99999999)
                    res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

    private static long gcdOfTwoNum(long a, long b) {
        if(b==0)return a;
        return gcdOfTwoNum(b, a%b);
    }
}
