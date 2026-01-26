package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = pacificAtlantic(heights);
        System.out.println(res);

    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res= new ArrayList<>();
        boolean [][] pacific = new boolean[m][n];
        boolean [][] atlantic = new boolean[m][n];
        //check for vertical
        for(int i=0;i<m;i++){
            pacificAtlanticFlowFinder(i,0,m,n, heights,pacific, Integer.MIN_VALUE);
            pacificAtlanticFlowFinder(i,n-1,m,n, heights,atlantic, Integer.MIN_VALUE);
        }
        //check for horizontal
        for(int j=0;j<n;j++){
            pacificAtlanticFlowFinder(0,j,m,n, heights,pacific, Integer.MIN_VALUE);
            pacificAtlanticFlowFinder(m-1,j,m,n, heights,atlantic, Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private static void pacificAtlanticFlowFinder(int i, int j, int m, int n, int[][] heights, boolean [][] visited, int prevHeight) {
        //base condition
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || prevHeight>heights[i][j]) return;
        visited[i][j] =true;
        for(int [] direction:directions){
            int i_= i+direction[0];
            int j_ = j+direction[1];
            pacificAtlanticFlowFinder(i_,j_,m,n,heights,visited,heights[i][j]);
        }

    }
}
