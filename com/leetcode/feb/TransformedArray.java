package com.com.leetcode.feb;

public class TransformedArray {
    public static void main(String[] args) {
        int[] nums = {-1, 4, -1};
        int[] res = constructTransformedArray(nums);
        for (int r : res)
            System.out.print(r + ", ");
    }

    private static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i] % n;
            int k = (i + num) % n;
            if (k < 0) k += n;
            res[i] = nums[k];
        }
        return res;
    }
}
