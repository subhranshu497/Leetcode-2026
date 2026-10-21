package com.com.leetcode.oct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathtoGetFood {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int[][][] t;
    private static int path = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char [][] grid = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        int path = getFood(grid);
        System.out.println(path);
    }

    private static int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int path = Integer.MAX_VALUE;
        //start from starting point
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='*'){
                    path = getFoodSolve(grid, m,n,visited,i,j);
                    break;
                }
            }
        }
        return path;
    }

    private static int getFoodSolve(char[][] grid, int m, int n, boolean[][] visited, int i, int j) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int []{i,j,0});
        visited[i][j] = true;
        while (!q.isEmpty()){
            int [] curr = q.poll();
            i = curr[0];
            j = curr[1];
            int dist = curr[2];
            //check for food
            if(grid[i][j]=='#'){
                return dist;
            }
            for(int [] dir:directions){
                int i_ = i+dir[0];
                int j_ = j+dir[1];
                //check oob
                if(i_>=0 && i_<m && j_>=0 && j_<n && !visited[i_][j_] && grid[i_][j_] !='X'){
                    visited[i_][j_] =true;
                    q.offer(new int[]{i_,j_,dist+1});
                }
            }
        }
        return -1;

    }

}
