package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    private static int count =0;
    public static void main(String[] args) {
        int [][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        int changeRoutes = minReorder(connections,n);
        System.out.println(changeRoutes);
    }

    private static int minReorder(int[][] connections, int n) {
        //the connection exists between two cities , we can take the convention 1
        //for simplying the process , we can create edges between same to cities and mark it 0
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int [] connection:connections){
            int u = connection[0];
            int v=connection[1];
            adjList.computeIfAbsent(u,k->new ArrayList<>()).add(new int[]{v,1});
            adjList.computeIfAbsent(v,k->new ArrayList<>()).add(new int[]{u,0});
        }
        //now start the dfs
        boolean [] visited = new boolean[n];
        connectCitiesDfs(adjList, visited,0);
        return count;
    }

    private static void connectCitiesDfs(Map<Integer, List<int[]>> adjList, boolean[] visited, int u) {
        //base case
        if(visited[u]) return;
        visited[u] = true;
        for(int[] vArr:adjList.getOrDefault(u, new ArrayList<>())){
            int v = vArr[0];
            int original = vArr[1];
            if(visited[v] && original==0)count +=1;
            connectCitiesDfs(adjList, visited,v);
        }
    }
}
