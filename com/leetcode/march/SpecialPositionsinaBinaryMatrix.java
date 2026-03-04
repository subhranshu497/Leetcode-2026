package com.com.leetcode.march;

public class SpecialPositionsinaBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        int count =numSpecial(mat);
        System.out.println(count);
    }

    private static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(mat[i][j]==1){
                    boolean checkCol= checkColumn(mat,i, j);
                    boolean checkRw = checkRow(mat, i, j);
                    if(checkCol && checkRw){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean checkRow(int[][] mat, int i, int j) {
        for(int k=0;k<mat[0].length;k++){
            if(k!=j && mat[i][k]==1){
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int[][] mat, int i, int j) {
        for(int k=0;k<mat.length;k++){
            if(k!=i && mat[k][j]==1){
                return false;
            }
        }
        return true;
    }
}
