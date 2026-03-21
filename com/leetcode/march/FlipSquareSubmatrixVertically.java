package com.com.leetcode.march;

public class FlipSquareSubmatrixVertically {
    public static void main(String[] args) {
        int [][] grid = {{3,4,2,3},{2,3,4,2}};
        int x = 0, y = 2, k = 2;
        int [][] res = reverseSubmatrix(grid, x,y,k);
        for(int [] a:res){
            for(int b:a)
                System.out.print(b+", ");
            System.out.println();
        }
    }

    private static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x+k-1;
        int right = y+k-1;
        while(top < bottom){
            for(int left = y;left<=right;left++){
                int temp = grid[top][left];
                grid[top][left] = grid[bottom][left];
                grid[bottom][left] = temp;
            }
            top++;
            bottom--;
        }
        return grid;
    }
}
