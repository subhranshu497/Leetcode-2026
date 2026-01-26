package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class NumberofIslands {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        char [] [] grid = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        int no_of_islands = numIslands(grid);
        System.out.println(no_of_islands);
    }

    private static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int no_of_islands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    no_of_islands +=1;
                    numOfIslandsDFS(i,j,m,n,grid, visited);
                }
            }
        }
        return no_of_islands;
    }

    private static void numOfIslandsDFS(int i, int j, int m, int n, char[][] grid, boolean[][] visited) {
        //boundary condition check
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0' || visited[i][j]) return;
        visited[i][j] = true;
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            numOfIslandsDFS(i_,j_,m,n,grid,visited);
        }
    }
}
