package com.com.leetcode.march;

import java.util.HashSet;

public class EqualSumGridPartitionII {
    private static long total;
    public static void main(String[] args) {
        int[][] grid = {{1, 4}, {2, 3}};
        boolean flag = canPartitionGridII(grid);
        System.out.println(flag);
    }

        public static boolean checkHorCuts(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            HashSet<Long> set = new HashSet<>();
            long top = 0;

            for (int i = 0; i < m - 1; i++) {

                for (int j = 0; j < n; j++) {
                    set.add((long)grid[i][j]);
                    top += grid[i][j];
                }

                long bottom = total - top;
                long diff = top - bottom;

                if (diff == 0) return true;

                if (diff == grid[0][0]) return true;
                if (diff == grid[0][n - 1]) return true;
                if (diff == grid[i][0]) return true;

                if (i > 0 && n > 1 && set.contains(diff)) {
                    return true;
                }
            }

            return false;
        }

        public static boolean canPartitionGridII(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // compute total
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    total += grid[i][j];
                }
            }

            // Horizontal
            if (checkHorCuts(grid)) return true;

            reverse(grid);

            if (checkHorCuts(grid)) return true;

            reverse(grid);

            // Transpose
            int[][] transposeGrid = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    transposeGrid[j][i] = grid[i][j];
                }
            }

            if (checkHorCuts(transposeGrid)) return true;

            reverse(transposeGrid);

            return checkHorCuts(transposeGrid);
        }

        // Helper to reverse rows
        private static void reverse(int[][] grid) {
            int top = 0, bottom = grid.length - 1;

            while (top < bottom) {
                int[] temp = grid[top];
                grid[top] = grid[bottom];
                grid[bottom] = temp;

                top++;
                bottom--;
            }
        }
}