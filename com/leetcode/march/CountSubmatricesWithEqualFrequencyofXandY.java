package com.com.leetcode.march;

public class CountSubmatricesWithEqualFrequencyofXandY {
    public static void main(String[] args) {
        char [][] grid = {{'X','Y','.'},{'Y','.','.'}};
        int res = numberOfSubmatrices(grid);
        System.out.println(res);
    }

    private static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        int [][] countX = new int[m+1][n+1];
        int [][] countY = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //prefix sum for X
                countX[i+1][j+1] = countX[i][j+1]+countX[i+1][j]-countX[i][j] + (grid[i][j]=='X'?1:0);
                //prefix sum for Y
                countY[i+1][j+1] = countY[i][j+1]+countY[i+1][j]-countY[i][j] + (grid[i][j]=='Y'?1:0);
                if(countX[i+1][j+1]==countY[i+1][j+1] && countX[i+1][j+1]>0) count++;
            }
        }
        return count;
    }
}
