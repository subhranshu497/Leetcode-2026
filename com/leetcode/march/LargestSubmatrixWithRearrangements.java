package com.com.leetcode.march;

import java.util.Arrays;
import java.util.Map;

public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int [][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        int area = largestSubmatrix(matrix);
        System.out.println(area);
    }

    private static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1)
                    matrix[i][j] +=matrix[i-1][j];
                else matrix[i][j] =0;
            }
        }
        for(int [] currentRow:matrix){
            Arrays.sort(currentRow);
            for(int height=n-1, width=1;height >=0 && currentRow[height]>0;height--, width++){
                int area = currentRow[height]*width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
