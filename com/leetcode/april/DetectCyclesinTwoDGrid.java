package com.com.leetcode.april;

public class DetectCyclesinTwoDGrid {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        char[][] grid = {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
        boolean hasCycle = containsCycle(grid);
        System.out.println(hasCycle);
    }

    private static boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    flag = dfsI(grid, visited, i, j, i,j, m, n, true);
                    if(flag) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsI(char[][] grid, boolean[][] visited, int i, int j,int pI, int pJ , int m, int n, boolean isFirst) {
        visited[i][j] = true;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || x>=m || y<0 || y>=n ) continue;
            if(grid[x][y] != grid[i][j]) continue;
            if(x==pI && y==pJ) continue;
            if(visited[x][y]) return true;
            if(dfsI(grid, visited, x, y, i,j, m, n, isFirst)) return true;
        }
        return false;
    }
}
