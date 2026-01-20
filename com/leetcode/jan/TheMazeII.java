package com.com.leetcode.jan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII {
    private static int maxdist = 0;
    public static void main(String[] args) {
        int [][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int [] start = {0,4}, destination = {4,4};
        int path = shortestDistance(maze, start, destination);
        System.out.println(path);

    }

    private static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int [][] dist = new int[m][n];
        for(int [] d:dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.offer(new int []{start[0], start[1],0});
        dist [start[0]][start[1]] =0;
        while (!pq.isEmpty()){
            int [] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            if(d>dist[r][c])continue;
            for(int [] direction:directions){
                int r_ = r;
                int c_ = c;
                int count = 0;
                while(r_+direction[0]>=0 && r_+direction[0] <m
                && c_+direction[1] >=0 && c_+direction[1]<n
                && maze[r_+direction[0]][c_+direction[1]]==0){
                    r_ +=direction[0];
                    c_ +=direction[1];
                    count++;
                }
                if(dist[r][c]+count < dist[r_][c_]){
                    dist[r_][c_] = count+dist[r][c];
                    pq.offer(new int []{r_,c_, dist[r_][c_]});
                }
            }
        }
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE ?-1:dist[destination[0]][destination[1]];
    }
}
