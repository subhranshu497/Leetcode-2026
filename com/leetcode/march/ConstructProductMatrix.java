package com.com.leetcode.march;

import java.util.Arrays;

public class ConstructProductMatrix {
    public static void main(String[] args) {
            int [][] grid = {{1,2},{3,4}};
        int [][] p = constructProductMatrix(grid);
        for(int []r: p){
            for(int a:r)
                System.out.print(a+", ");
            System.out.println();
        }
    }

    private static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long tempProd = 1;
        int MOD = 12345;
        int p[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                p[i][j] = (int)tempProd;
                tempProd =(tempProd*(grid[i][j]%MOD)%MOD);
            }
        }
        // Step 2: Backward Pass (Suffix)
        tempProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) ((p[i][j] * tempProd) % MOD);
                tempProd = (tempProd * (grid[i][j] % MOD)) % MOD;
            }
        }
        return p;
    }
}
