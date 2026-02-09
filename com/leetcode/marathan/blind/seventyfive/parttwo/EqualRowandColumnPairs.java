package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs {
    public static void main(String[] args) {
        int [][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int pairs = equalPairs(grid);
        System.out.println(pairs);
    }

    private static int equalPairs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]);
                sb.append("*");
            }
            rowMap.put(sb.toString(),rowMap.getOrDefault(sb.toString(),0)+1);
        }
        for(int j=0;j<n;j++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<m;i++){
                sb.append(grid[i][j]);
                sb.append("*");
            }
            colMap.put(sb.toString(),colMap.getOrDefault(sb.toString(),0)+1);
        }
        int pairs = 0;
        for(Map.Entry<String, Integer> e:rowMap.entrySet()){
            String key = e.getKey();
            int val = e.getValue();
            if(colMap.containsKey(key)){
                pairs +=val*colMap.get(key);
            }
        }
        return pairs;
    }
}
