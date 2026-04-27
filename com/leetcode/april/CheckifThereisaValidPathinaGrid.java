package com.com.leetcode.april;

import java.util.HashMap;
import java.util.Map;

public class CheckifThereisaValidPathinaGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,1,2}};
        SolutionDay0426 solution = new SolutionDay0426();
        boolean hasPath = solution.hasValidPath(grid);
        System.out.println(hasPath);
    }
}
class SolutionDay0426{

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        //create the map from the numbers to the directions
        Map<Integer, int[][]> map = new HashMap<>();
        map.put(1, new int[][]{{0, -1}, {0, 1}});
        map.put(2, new int[][]{{-1, 0}, {1, 0}});
        map.put(3, new int[][]{{0, -1}, {1, 0}});
        map.put(4, new int[][]{{0, 1}, {1, 0}});
        map.put(5, new int[][]{{0, -1}, {-1, 0}});
        map.put(6, new int[][]{{0, 1}, {-1, 0}});
        return dfsI(0,0,m,n,grid,visited, map);
    }

    private boolean dfsI(int i, int j, int m, int n, int[][] grid, boolean[][] visited, Map<Integer,int[][]> map) {
        //base case
        if(i==m-1 && j==n-1) return true;
        visited[i][j] = true;
        int current = grid[i][j];
        int[][] directions = map.get(current);
        for(int [] direction:directions){
            int nextI = i+direction[0];
            int nextJ = j+direction[1];
            if(checkNotOutOfBound(nextI, nextJ, m, n, visited) && isValidMove(grid[nextI][nextJ], direction, map)){
                if(dfsI(nextI, nextJ, m, n, grid, visited, map)) return true;
            }
        }
        return false;
    }

    private boolean isValidMove(int next, int[] direction, Map<Integer, int[][]> map) {
        int curr_dir_x = direction[0];
        int curr_dir_y = direction[1];
        int [][] next_dirs = map.get(next);
        int next_dirs_0_x = next_dirs[0][0];
        int  next_dirs_0_y =next_dirs[0][1];
        int next_dirs_1_x = next_dirs[1][0];
        int next_dirs_1_y = next_dirs[1][1];
        if(curr_dir_x == -1 && next_dirs_0_x == 1) return true;
        if(curr_dir_x == 1 && next_dirs_0_x == -1) return true;
        if(curr_dir_x == -1 && next_dirs_1_x == 1) return true;
        if(curr_dir_x == 1 && next_dirs_1_x == -1) return true;
        if(curr_dir_y == -1 && next_dirs_0_y == 1) return true;
        if(curr_dir_y == 1 && next_dirs_0_y == -1) return true;
        if(curr_dir_y == -1 && next_dirs_1_y == 1) return true;
        if(curr_dir_y == 1 && next_dirs_1_y == -1) return true;
        return false;
    }

    private boolean checkNotOutOfBound(int i, int j, int m, int n, boolean[][] visited){
        return i>=0 && i<m && j>=0 && j<n && !visited[i][j];
    }
}
