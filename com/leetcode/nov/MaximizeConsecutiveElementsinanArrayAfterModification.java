package com.com.leetcode.nov;

import java.util.Arrays;

public class MaximizeConsecutiveElementsinanArrayAfterModification {
    public static void main(String[] args) {
        int [] nums = {2,1,5,1,1};
        int res = maxSelectedElements(nums);
        System.out.println(res);
    }
    public static int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int best = 1, keep = 1, bump = 1, last = -10;
        for (int x : nums) {
            switch (x - last) {
                case 0 -> bump = keep + 1;  // x repeat: bump it on top of keep
                case 1 -> { keep++; bump++; }  // x extends keep, x + 1 extends bump
                case 2 -> { keep = bump + 1; bump = 1; }  // x extends bump, x + 1 starts over
                default -> keep = bump = 1;
            }
            best = Math.max(best, Math.max(keep, bump));
            last = x;
        }
        return best;
    }
}
