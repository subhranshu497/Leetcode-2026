package com.com.leetcode.oct;

public class NumberOfClosedIslands {
    private static int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        int [][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int islands = closedIsland(grid);
        System.out.println(islands);
    }

    private static int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        for(int i=0;i<m;i++){
            for (int j =0;j<n;j++){
                if(grid[i][j]==0){
                    boolean flag =closedIslandSolve(grid, i,j,m,n);
                    if(flag) count +=1;
                }
            }
        }
        return count;
    }

    private static boolean closedIslandSolve(int[][] grid, int i, int j, int m, int n) {
        //base case
        if(i<0 || i>=m || j<0 || j>=n)return false;
        if(grid[i][j]==1) return true;
        grid[i][j] =1;

        boolean rightClosed = closedIslandSolve(grid,i,j+1,m,n);
        boolean leftClosed = closedIslandSolve(grid,i,j-1,m,n);
        boolean upClosed = closedIslandSolve(grid,i-1,j,m,n);
        boolean downClosed = closedIslandSolve(grid,i+1,j,m,n);

        if(rightClosed && leftClosed && upClosed && downClosed) return true;

        return false;
    }
}
