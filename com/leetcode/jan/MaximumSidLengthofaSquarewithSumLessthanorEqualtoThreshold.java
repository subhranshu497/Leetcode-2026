package com.com.leetcode.jan;

import java.util.ArrayList;
import java.util.List;

public class MaximumSidLengthofaSquarewithSumLessthanorEqualtoThreshold {
    public static void main(String[] args) {
        int [][] mat = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        int threshold = 1;
        int side = maxSideLength(mat, threshold);
        System.out.println(side);
    }

    private static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] prefixSum = new int[m][n];
        //form the prefix sum matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixSum[i][j] = mat[i][j]
                        +(i > 0 ? prefixSum[i-1][j]:0)
                        +(j>0 ? prefixSum[i][j-1]:0)
                        -((i>0 && j>0)?prefixSum[i-1][j-1]:0);
            }
        }
        int side = 0;
        //iterate
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                for(int k=0;k<Math.min(m-i, n-j);k++){
                    int r2 = i+k;
                    int c2 = j+k;
                    int sum = sumOfSquare(i,j,r2,c2, prefixSum);
                    if(sum <=threshold){
                        side = Math.max(side, k+1);
                    }else break;
                }
            }
        }
        return side;
    }

    private static int sumOfSquare(int i, int j, int r2, int c2, int[][] prefixSum) {
        int sum = prefixSum[r2][c2];
        sum -= (i>0)?prefixSum[i-1][c2]:0;
        sum -=(j>0)?prefixSum[r2][j-1]:0;
        sum +=(i>0 && j>0)?prefixSum[i-1][j-1]:0;

        return sum;
    }
}
