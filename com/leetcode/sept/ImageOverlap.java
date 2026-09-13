package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class ImageOverlap {
    public static void main(String[] args) {
        int [][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
        int [][] img2 = {{0,0,0},{0,1,1},{0,0,1}};
        int count = largestOverlap(img1, img2);
        System.out.println(count);
    }

    private static int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        // collect every coordinate that holds a 1
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) A.add(new int[]{i, j});
                if (img2[i][j] == 1) B.add(new int[]{i, j});
            }
        }
        int[][] cnt = new int[2 * n][2 * n];
        int best = 0;
        for (int[] a : A) {
            for (int[] b : B) {
                int dx = b[0] - a[0] + n;
                int dy = b[1] - a[1] + n;
                best = Math.max(best, ++cnt[dx][dy]);
            }
        }
        return best;
    }
}
