package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
    public static void main(String[] args) {
        int n =5;
        int [][] edges = {{0,1},{0,2},{0,3},{1,4}};
        boolean flag = validTree(n, edges);
        System.out.println(flag);
    }

    private static boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }
        System.out.println(adjList);
        boolean [] visited = new boolean[n];
        int parent =-1;
        //start dfs
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(!visited[i] && isValidGraphDFS(adjList, visited, parent,i))return false;
        }
        return true;
    }

    private static boolean isValidGraphDFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int parent, int u) {
        //base condition
        if(visited[u])return false;
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(v==parent)continue;
            else if(visited[v]) return true; // cycle is present
            else{
                isValidGraphDFS(adjList,visited,u,v);
            }
        }
        return false;
    }
}
