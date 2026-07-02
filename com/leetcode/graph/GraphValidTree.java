package com.com.leetcode.graph;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        int n =5 ;
        int [][] edges = {{0,1},{1,2},{1,3},{1,4},{2,3}};
        boolean flag = validTreeI(n,edges);
        System.out.println(flag);
    }

    private static boolean validTreeI(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        //to keep track of visited nodes
        boolean [] visited = new boolean[n];
        //start dfs
        boolean flag = cycleDetectionBFS(adjList, n, visited);
        for(boolean f:visited)
            if(!f)return false;
        return flag;
    }

    private static boolean cycleDetectionBFS(Map<Integer, List<Integer>> adjList, int n, boolean[] visited) {
       Queue<int[]> q= new LinkedList<>();
       //push to q current and parent
        q.offer(new int[]{0,-1});
        visited[0] = true;
        while(!q.isEmpty()){
            int [] arr= q.poll();
            int u = arr[0];
            int parent = arr[1];
            for(int v:adjList.getOrDefault(u, new ArrayList<>())){
                if(v== parent)continue;
                if(visited[v]) return false;
                visited[v] = true;
                q.offer(new int[]{v,u});
            }
        }
        return true;
    }

//    private static boolean cycleDetectionDFS(Map<Integer, List<Integer>> adjList, int n, boolean[] visited, int u, int parent) {
//        //base case
//        if(visited[u]) return false;
//        //if not visited mark it visited
//        visited[u] = true;
//        //explore other children of u
//        for(int v:adjList.getOrDefault(u,new ArrayList<>())){
//            if(v==parent)continue;
//            if(!cycleDetectionDFS(adjList,n,visited,v,u))return false;
//        }
//        return true;
//    }
}
