package com.com.leetcode.april;

import java.util.Arrays;

public class MaximumPathScoreinaGrid {
    private static int[][][] memo;

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,2}};
        int k = 1;
        int res = maxPathScore(grid, k);
        System.out.println(res);
    }

    private static int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // memo[i][j][remainingK] = max score from (i,j) to (m-1,n-1) with remainingK budget left
        memo = new int[m][n][k + 1];
        for (int[][] a : memo) for (int[] b : a) Arrays.fill(b, Integer.MIN_VALUE);
        return dfsI(0, 0, m, n, grid, k);
    }

    // returns max score from (i,j) to destination with k budget remaining, or -1 if impossible
    private static int dfsI(int i, int j, int m, int n, int[][] grid, int k) {
        int cost = grid[i][j] == 0 ? 0 : 1;
        if (cost > k) return -1; // can't afford current cell

        int remaining = k - cost;

        if (i == m-1 && j == n-1) return grid[i][j];

        if (memo[i][j][remaining] != Integer.MIN_VALUE) return memo[i][j][remaining];

        int best = -1;
        // move down
        if (i+1 < m) {
            int sub = dfsI(i+1, j, m, n, grid, remaining);
            if (sub != -1) best = Math.max(best, grid[i][j] + sub);
        }
        // move right
        if (j+1 < n) {
            int sub = dfsI(i, j+1, m, n, grid, remaining);
            if (sub != -1) best = Math.max(best, grid[i][j] + sub);
        }

        memo[i][j][remaining] = best;
        return best;
    }
}
