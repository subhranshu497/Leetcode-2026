package com.com.leetcode.may;

public class RotateFunction {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        int res = maxRotateFunction(nums);
        System.out.println(res);
    }

    private static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int max = f;
        for (int i = n - 1; i >= 1; i--) {
            f += sum - n * nums[i];
            max = Math.max(max, f);
        }
        return max;
    }
}
