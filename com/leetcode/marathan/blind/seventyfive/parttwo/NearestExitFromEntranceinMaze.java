package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestExitFromEntranceinMaze {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int minAttempt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[][] maze = {{'.','+'}};
        int[] entrance = {0,0};
        int attempt = nearestExit(maze, entrance);
        System.out.println(attempt);
    }

    private static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        int attempt = 0;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int currAttempt = curr[2];
            for(int [] direction:directions){
                int i_ = i+direction[0];
                int j_ = j+direction[1];
                if(i_>=0 && i_<m && j_>=0 && j_<n && maze[i_][j_]=='.'){
                    if(i_==0 || j_==0 || i_==m-1 || j_==n-1)
                        return currAttempt+1;
                    maze[i_][j_] = '+';
                    q.add(new int[]{i_,j_,currAttempt+1});
                }

            }
        }
        return -1;
    }
}
