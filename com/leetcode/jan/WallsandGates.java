package com.com.leetcode.jan;

import java.util.Map;
import java.util.Set;

public class WallsandGates {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
        //print the output
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                System.out.print(rooms[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0){
                    wallsAndGatesDFS(rooms, m,n,i,j);
                }
            }
        }
    }

    private static void wallsAndGatesDFS(int[][] rooms, int m, int n, int i, int j) {
        for(int[] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            //check for boundary
            if(i_>=0 && i_<m && j_>=0 && j_<n && rooms[i_][j_]>rooms[i][j]+1){
                    rooms[i_][j_] = rooms[i][j]+1;
                    wallsAndGatesDFS(rooms,m,n,i_,j_);
            }
        }
    }
}
