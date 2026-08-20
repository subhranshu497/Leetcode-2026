package com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int n = 3;
        int [][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        int max = maxNumberOfFamilies(reservedSeats,n);
        System.out.println(max);
    }

    private static int maxNumberOfFamilies(int[][] reservedSeats, int n) {
        Map<Integer, Integer> rowBitmasks = new HashMap<>();

        // Build a 10-bit mask for rows with reserved seats
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rowBitmasks.put(row, rowBitmasks.getOrDefault(row, 0) | (1 << col));
        }

        // Unreserved rows can fit 2 families each
        int res = (n - rowBitmasks.size()) * 2;

        // Check seat availability using bitwise AND operations
        // 0b0000111100 = seats 2,3,4,5 (left)
        // 0b0011110000 = seats 4,5,6,7 (middle)
        // 0b1111000000 = seats 6,7,8,9 (right)
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : rowBitmasks.values()) {
            boolean canLeft = (mask & leftMask) == 0;
            boolean canRight = (mask & rightMask) == 0;
            boolean canMiddle = (mask & middleMask) == 0;

            if (canLeft && canRight) {
                res += 2; // Can fit both left and right families
            } else if (canLeft || canRight || canMiddle) {
                res += 1; // Can fit at least one family
            }
        }

        return res;
    }
}
