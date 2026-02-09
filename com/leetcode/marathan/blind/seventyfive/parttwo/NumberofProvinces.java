package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofProvinces {
    public static void main(String[] args) {
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int provinces = findCircleNum(isConnected);
        System.out.println(provinces);
    }

    private static int findCircleNum(int[][] isConnected) {
        //create the adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adjList.computeIfAbsent(i, k->new ArrayList<>()).add(j);
                }
            }
        }
        int count = 0;
        boolean [] vistied = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vistied[i]){
                count +=1;
                findCirNumDfs(adjList, i,vistied);
            }
        }
        return count;
    }

    private static void findCirNumDfs(Map<Integer, List<Integer>> adjList, int u, boolean[] vistied) {
        //base case
        if(vistied[u]) return;
        vistied[u]= true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            findCirNumDfs(adjList, v, vistied);
        }
    }
}
