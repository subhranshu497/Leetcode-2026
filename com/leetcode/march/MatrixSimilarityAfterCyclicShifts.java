package com.com.leetcode.march;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixSimilarityAfterCyclicShifts {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k =4;
        boolean flag = areSimilar(mat,k);
        System.out.println(flag);
    }

    private static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] copyMat = Arrays.stream(mat)
                .map(int[]::clone)
                .toArray(int[][]::new);
        int count = k;
        while (count > 0) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i % 2 == 0) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[i][j + 1];
                    mat[i][j + 1] = temp;
                }
            }
        }
        count--;
    }
        count =k;
        while (count>0) {
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j > 0; j--) {
                    if (i % 2 != 0) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[i][j - 1];
                        mat[i][j - 1] = temp;
                    }
                }
            }
            count--;
        }
        //check for the equality of two matrixs
        return IntStream.range(0,m)
                .allMatch(i->Arrays.equals(mat[i],copyMat[i]));
    }
}
