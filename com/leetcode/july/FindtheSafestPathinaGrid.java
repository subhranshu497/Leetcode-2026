package com.com.leetcode.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindtheSafestPathinaGrid {
    private static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        List<Integer> list1= List.of(1,0,0);
        List<Integer> list2= List.of(0,0,0);
        List<Integer> list3= List.of(0,0,1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        int max = maximumSafenessFactor(grid);
        System.out.println(max);
    }

    //safeness factor = manhatton dist from a cell to thief cell
    //lets - (r,c) - thief
    //safeness factor = |x-r|+|y-c|
    //return the max safeness factor
    private static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        //step 1 - compute the distance from each cell to the nearest thief cell
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        //put all thief cells in the queue
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.offer(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        //bfs to compute the distance from each cell to the nearest thief cell
        while(!q.isEmpty()){
            int [] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            for(int [] direction:directions){
                int x_ = x+direction[0];
                int y_ = y+direction[1];
                //check for valid cell
                if(x_>=0 && x_<n && y_>=0 && y_<n && dist[x_][y_]==0 && grid.get(x_).get(y_)==0){
                    dist[x_][y_] = dist[x][y]+1;
                    q.offer(new int[]{x_,y_});
                }
            }
        }
        //step 2 - binary search to find the maximum safeness factor
        int left =0;
        int right = n;
        int safenessFactor =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canReachEnd(dist,mid)){
                safenessFactor = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return safenessFactor;
    }

    private static boolean canReachEnd(int[][] dist, int mid) {
        int n = dist.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        if (dist[0][0]>=mid){
            q.offer(new int[]{0,0});
            visited[0][0] = true;
        }
        while(!q.isEmpty()){
            int [] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            if(x==n-1 && y==n-1)return true;
            for(int [] direction:directions){
                int x_ = x+direction[0];
                int y_ = y+direction[1];
                //check for valid cell
                if(x_>=0 && x_<n && y_>=0 && y_<n && !visited[x_][y_] && dist[x_][y_]>=mid){
                    visited[x_][y_] = true;
                    q.offer(new int[]{x_,y_});
                }
            }
        }
        return false;
    }
}
