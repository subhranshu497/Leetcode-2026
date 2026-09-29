package com.com.leetcode.sept;

import java.util.Arrays;
import java.util.Stack;

public class CheckifThereIsaValidParenthesesStringPath {
    private static int [][][] t;
    public static void main(String[] args) {
        char[][] grid = {{')',')'},{'(','('}};
        boolean flag = hasValidPath(grid);
        System.out.println(flag);
    }

    private static boolean hasValidPath(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        t = new int [m][n][((m+n)/2)+1];
        for(int[][]t2:t){
            for(int [] t1:t2){
                Arrays.fill(t1, -1);
            }
        }
        return hasValidPathSolve(grid,m,n,0,0,0);
    }

    private static boolean hasValidPathSolve(char[][] grid, int m, int n, int i, int j, int open) {
        //oob
        if(i==m || j==n)return false;

        //open parenthesis count
        if(grid[i][j]=='(')open++;
        else open--;

        if(open <0 || open > (m+n)/2)return false;
        //base case
        if(i==m-1 && j==n-1)return open==0;
        if(t[i][j][open] != -1)return t[i][j][open] ==1;
        boolean right = hasValidPathSolve(grid,m,n,i,j+1,open);
        boolean down = hasValidPathSolve(grid,m,n,i+1,j,open);
        boolean res = right || down;
        t[i][j][open] = res ? 1:0;
        return res;
    }


}
