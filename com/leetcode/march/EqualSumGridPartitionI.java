package com.com.leetcode.march;

public class EqualSumGridPartitionI {
    public static void main(String[] args) {
        int [][] grid = {{1,4},{2,3}};
        System.out.println(canPartitionGrid(grid));
    }

    private static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) totalSum += val;
        }
        // Must be even to split into two equal parts
        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;
        // Check Horizontal Splits (between rows)
        long currentRowsSum = 0;
        for (int i = 0; i < m - 1; i++) { // m-1 because parts must be non-empty
            for (int j = 0; j < n; j++) {
                currentRowsSum += grid[i][j];
            }
            if (currentRowsSum == target) return true;
        }
        // Check Vertical Splits (between columns)
        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                currentColSum += grid[i][j];
            }
            if (currentColSum == target) return true;
        }
        return false;
    }
}
