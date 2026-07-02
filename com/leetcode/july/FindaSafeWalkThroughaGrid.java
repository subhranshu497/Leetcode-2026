package com.com.leetcode.july;

import java.util.ArrayList;
import java.util.List;

public class FindaSafeWalkThroughaGrid {
    private static int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(List.of(0,1,0,0,0));
        grid.add(List.of(0, 1, 0,1,0));
        grid.add(List.of(0, 0, 0,1,0));
        int health = 1;
        boolean flag = findSafeWalk(grid,health);
        System.out.println(flag);
    }

    private static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int [][] healthTracker = new int[m][n];
        boolean flag = findSafeWalkSolve(grid,health,0,0,m,n,healthTracker);
        return flag;
    }

    private static boolean findSafeWalkSolve(List<List<Integer>> grid, int health, int i, int j, int m, int n, int[][] healthTracker) {
        //base case
        if(i<0 || i>=m || j<0 || j>=n)return false;
        health = grid.get(i).get(j)==1?health-1:health;
        if(health<=0)return false;
        if(i==m-1 && j==n-1 && health>=1)return true;
        //check if we have already visited this cell with more health
        if(healthTracker[i][j]>=health)return false;
        //update health tracker
        healthTracker[i][j] = health;
        //execute
        for(int [] direction:directions){
            int x = i+direction[0];
            int y = j+direction[1];
            if(findSafeWalkSolve(grid,health,x,y,m,n,healthTracker))return true;
        }
        return false;
    }

    //brute force

//    private static boolean findSafeWalkSolve(List<List<Integer>> grid, int health, int i, int j, int m, int n, boolean[][] visited) {
//        //base case
//        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])return false;
//        health = grid.get(i).get(j)==1?health-1:health;
//        if(health<=0)return false;
//        if(i==m-1 && j==n-1 && health>=1)return true;
//        //do
//        visited[i][j] = true;
//        //execute
//        for(int [] direction:directions){
//            int x = i+direction[0];
//            int y = j+direction[1];
//            if(findSafeWalkSolve(grid,health,x,y,m,n,visited))return true;
//        }
//        //undo
//        visited[i][j] = false;
//        return false;
//    }
}
