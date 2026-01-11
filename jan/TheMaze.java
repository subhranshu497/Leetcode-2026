package com.jan;

public class TheMaze {

    private static int [][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int [] start = {0,4};
        int [] end = {4,4};
        boolean flag = hasPath(maze, start, end);
        System.out.println(flag);
    }

    private static boolean hasPath(int[][] maze, int[] start, int[] end) {
        int m = maze.length;
        int n = maze[0].length;
        boolean [][] visited = new boolean[m][n];
       return hasPathDFS(maze, end, start[0],start[1],m,n,visited);
    }

    private static boolean hasPathDFS(int[][] maze, int[] end, int i, int j, int m, int n, boolean[][] visited) {
        if(visited[i][j]) return false;
        if(i==end[0] && j==end[1]) return true;
        visited[i][j] = true;
        for(int [] direction:directions){
            int i_ = i;
            int j_ = j;
            while((i_+direction[0])>=0 && (i_+direction[0])<m
            && j_+direction[1] >=0 && j_+direction[1]<n &&
            maze[i_+direction[0]][j_+direction[1]]==0){
                i_+=direction[0];
                j_+=direction[1];
            }
            if(hasPathDFS(maze,end,i_,j_,m,n,visited)) return true;
        }
        return false;
    }
}
