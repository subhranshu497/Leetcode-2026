package com.com.leetcode.sept;

public class SmallestStableIndexII {
    public static void main(String[] args) {
        int [] nums = {5,0,1,4};
        int k =3;
        int res = firstStableIndexI(nums, k);
        System.out.println(res);
    }

    private static int firstStableIndexI(int[] nums, int k) {
        int maxSoFar = -1;
        int cand = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if (i == cand) max = maxSoFar;

            if (nums[i] < max - k)
                cand = i + 1;
        }

        return cand < nums.length ? cand : -1;
    }
}
