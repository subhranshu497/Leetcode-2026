package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class AndroidUnlockPatterns {
    public static void main(String[] args) {
        int m =1;
        int n =1;
        int res = numberOfPatterns(m,n);
        System.out.println(res);
    }

    private static int numberOfPatterns(int m, int n) {
       int [][] skip = new int[10][10];
       //edges
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;

        // Diagonals passing through center dot 5
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        int count =0;
        for(int i=m;i<=n;i++){
            //for 4 corners
            count +=numberOfPatternsDFS(1,i-1,visited, skip)*4;
            //for 4 edges
            count +=numberOfPatternsDFS(2,i-1,visited, skip)*4;
            //for center
            count +=numberOfPatternsDFS(5,i-1,visited, skip);
        }
        return count;
    }

    private static int numberOfPatternsDFS(int curr, int rem, boolean[] visited, int[][] skip) {
        //base case
        if(rem==0) return 1;

        //start backtracking
        visited[curr]= true;
        int count =0;
        for(int next=1;next<=9;next++){
            int middle = skip[curr][next];
            //either there is no middle dots so 0 or already visited
            if(!visited[next] && (middle==0 || visited[middle])){
                count +=numberOfPatternsDFS(next, rem-1, visited,skip);
            }
        }
        visited[curr]=false;
        return count;
    }
}
