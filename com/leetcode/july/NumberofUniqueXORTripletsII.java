package com.com.leetcode.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberofUniqueXORTripletsII {
    public static void main(String[] args) {
        int [] nums = {1,2};
        int res = uniqueXorTripletsII(nums);
        System.out.println(res);
    }

    private static int uniqueXorTripletsII(int[] nums) {
        int n = nums.length;

        // 1. Find max element to determine upper bound for XOR values (power of 2)
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int T = 1;
        while (T <= maxVal) {
            T <<= 1;
        }

        // 2. State 1: Primitive boolean array for unique pair XORs
        boolean[] pairXors = new boolean[T];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXors[nums[i] ^ nums[j]] = true;
            }
        }

        // 3. State 2: Combine pair XORs with elements to get triplet XORs
        boolean[] tripletXors = new boolean[T];
        for (int i = 0; i < T; i++) {
            if (pairXors[i]) {
                for (int num : nums) {
                    tripletXors[i ^ num] = true;
                }
            }
        }

        // 4. Count total unique triplet XOR values
        int count = 0;
        for (boolean present : tripletXors) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}
