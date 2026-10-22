package com.com.leetcode.oct;

/**
 * LeetCode 3942: Minimum Operations to Sort a Permutation
 * https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
 *
 * Operations allowed:
 * 1. Reverse the entire array.
 * 2. Rotate left by one (move nums[0] to the end).
 */
public class MinimumOperationstoSortaPermutation {

    public static void main(String[] args) {
        // Example 1: [0, 2, 1] -> Expected: 2
        int[] nums1 = {0, 2, 1};
        System.out.println("Output 1: " + minOperations(nums1)); // Expected: 2

        // Example 2: [1, 0, 2] -> Expected: 2
        int[] nums2 = {1, 0, 2};
        System.out.println("Output 2: " + minOperations(nums2)); // Expected: 2

        // Example 3: [2, 0, 1, 3] -> Expected: -1
        int[] nums3 = {2, 0, 1, 3};
        System.out.println("Output 3: " + minOperations(nums3)); // Expected: -1
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        // Find the index of 0
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        // Check if array is cyclically increasing: nums[(zeroIdx + i) % n] == i
        boolean isInc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx + i) % n] != i) {
                isInc = false;
                break;
            }
        }

        // Check if array is cyclically decreasing: nums[(zeroIdx - i + n) % n] == i
        boolean isDec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx - i + n) % n] != i) {
                isDec = false;
                break;
            }
        }

        // If it's neither cyclically increasing nor decreasing, sorting is impossible
        if (!isInc && !isDec) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        // If cyclically increasing:
        // Option A: Rotate left by zeroIdx times -> zeroIdx operations
        // Option B: Reverse, rotate left, reverse (right rotations) -> (n - zeroIdx) + 2 operations
        if (isInc) {
            minOps = Math.min(minOps, zeroIdx);
            if (zeroIdx > 0) {
                minOps = Math.min(minOps, (n - zeroIdx) + 2);
            }
        }

        // If cyclically decreasing:
        // Option C: Rotate left so 0 reaches index n - 1, then reverse -> ((zeroIdx + 1) % n) + 1 operations
        // Option D: Reverse first, then rotate left -> n - zeroIdx operations
        if (isDec) {
            int op1 = ((zeroIdx + 1) % n) + 1;
            int op2 = n - zeroIdx;
            minOps = Math.min(minOps, Math.min(op1, op2));
        }

        return minOps;
    }
}
