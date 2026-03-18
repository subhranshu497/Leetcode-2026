package com.com.leetcode.march;

public class CountSubmatricesWithTopLeftElementandSumLessThank {
    public static void main(String[] args) {
        int [][] grid = {{7,2,9},{1,5,0},{2,6,6}};
        int k = 20;
        int res = countSubmatrices(grid, k);
        System.out.println(res);
    }

    private static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r + 1][c + 1] = grid[r][c] + dp[r][c + 1] + dp[r + 1][c] - dp[r][c];
                if (dp[r + 1][c + 1] <= k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
