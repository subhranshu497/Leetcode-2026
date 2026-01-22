package com.com.leetcode.concept.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int path = minimumEffortPath(heights);
        System.out.println(path);
    }

    private static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] distanceGrid = new int[m][n];
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        //fill the distance grid with infinite
        for(int [] g:distanceGrid)
            Arrays.fill(g, Integer.MAX_VALUE);
        //assign dist 0 to the starting point as the distance between self is 0
        distanceGrid[0][0] =0;
        //take a min heap for processing where 0th index is the distance, 1st is ith cor and 2nd is jth cor
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int []{0,0,0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int dist = curr[0];
            int i = curr[1];
            int j = curr[2];
            for(int [] direction:directions){
                if(i+direction[0] <m && i+direction[0] >=0 && j+direction[1] < n && j+direction[1] >=0){ //boundary check
                    int i_ = i+direction[0];
                    int j_ = j+direction[1];
                    int diff = Math.abs(heights[i][j]-heights[i_][j_]);
                    int temp_dist = Math.max(diff, dist);
                    int existing_dist = distanceGrid[i_][j_];
                    if(existing_dist > temp_dist){
                        distanceGrid[i_][j_] = temp_dist;
                        pq.offer(new int[]{temp_dist, i_,j_});
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(distanceGrid[i][j]+", ");
            }
            System.out.println();
        }
        return distanceGrid[m-1][n-1];
    }
}
