package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        int [][] grid = {{0}};
        int time = orangesRotting(grid);
        System.out.println(time);
    }

    private static int orangesRotting(int[][] grid) {
        int time =-1;
        Queue<int[]>q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        //loop through the grid anf find the cell for rotten orange
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                set.add(grid[i][j]);
                if(grid[i][j]==2){
                    q.add(new int []{i,j});
                }
            }
        }
        if(!set.contains(2)){
            if(set.contains(0) && !set.contains(1)) return 0;
            else if(set.contains(1))return -1;
            else return -1;
        }
        //start the processing
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0)
            {
                int [] curr = q.poll();
                int i =curr[0];
                int j = curr[1];
                for(int [] direction:directions){
                    int i_ = i+direction[0];
                    int j_ = j+direction[1];
                    if(i_>=0 && i_<m && j_>=0 && j_<n && grid[i_][j_]==1){
                        q.add(new int[]{i_,j_});
                        grid[i_][j_] =2; //marked visited
                    }
                }
            }
            time +=1;
        }
        //check if all the oranges got rotten
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        //print the grid
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+", ");
            }
            System.out.println();
        }
        return time;
    }
}
