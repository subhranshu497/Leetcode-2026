package com.com.leetcode.march;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        int [][] mat = {{0,1},{1,0}}, target = {{1,0},{0,1}};
        boolean flag = findRotation(mat, target);
        System.out.println(flag);
    }

    private static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        //we need to check 4 times - 0, 90, 180, 270
        for(int i=0;i<4;i++){
            if(Arrays.deepEquals(mat, target))return true;
            mat = rotateNintyDegree(mat,n);
        }
        return false;
    }

    private static int[][] rotateNintyDegree(int[][] mat, int n) {
        int [][] rotated = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotated[i][j] = mat[j][n-1-i];
            }
        }
        return rotated;
    }


}
