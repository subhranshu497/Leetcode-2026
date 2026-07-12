package com.com.leetcode.july;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CounttheNumberofCompleteComponents {
    int[] parent;
    int[] rank;

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        int res = countCompleteComponents(n, edges);
        System.out.println(res);
    }

    //using BFS
    private static int countCompleteComponents(int n, int[][] edges) {
        Queue<Integer> q = new java.util.LinkedList<>();
        //step 1: create the adjacency list
        Map<Integer, List<Integer>> adjList = new java.util.HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        //step -2 - start bfs in a loop
        //it will be a multisource bfs
        for(int i=0;i<n;i++) {
            if(visited[i]) continue;
            q.add(i);
            visited[i] = true;
            int[] verAndEdge = new int[2];
            while (!q.isEmpty()) {
                int u = q.poll();
                verAndEdge[0]++;
                verAndEdge[1] += adjList.getOrDefault(u, new ArrayList<>()).size();
                for (int v : adjList.getOrDefault(u, new ArrayList<>())) {
                    if (!visited[v]) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
            int vertices = verAndEdge[0] * (verAndEdge[0] - 1) / 2;
            int edgesCount = verAndEdge[1] / 2;
            if (vertices == edgesCount) count++;
        }
        return count;
    }
}
    //using DFS
//    private static int countCompleteComponents(int n, int[][] edges) {
//        //step 1: create the adjacency list
//        Map<Integer, List<Integer>> adjList = new java.util.HashMap<>();
//        for(int [] edge:edges){
//            int u = edge[0];
//            int v = edge[1];
//            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
//            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
//        }
//        boolean [] visited = new boolean[n];
//        int count =0;
//        int [] verAndEdge;
//        //step -2 - start dfs in a loop
//        for(int i=0;i<n;i++){
//            if(!visited[i]){
//                verAndEdge = new int[2];
//                countCompleteComponentsDfs(i, adjList, visited, verAndEdge);
//                int vertices = verAndEdge[0]*(verAndEdge[0]-1)/2;
//                int edgesCount = verAndEdge[1]/2;
//                if(vertices == edgesCount) count++;
//            }
//
//        }
//        return count;
//    }
//
//    private static void countCompleteComponentsDfs(int u, Map<Integer, List<Integer>> adjList, boolean[] visited, int []verAndEdge) {
//        //base case
//        if(visited[u]) return;
//        visited[u] = true;
//        verAndEdge[0]++;
//        verAndEdge[1] += adjList.get(u).size();
//        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
//            countCompleteComponentsDfs(v, adjList, visited, verAndEdge);
//        }
//    }
//}

//    private static int countCompleteComponents(int n, int[][] edges) {
//        //step 1: create the edge count
//        Map<Integer, Integer> edgeCount = new java.util.HashMap<>();
//        DSU dsu = new DSU(n);
//        for(int [] edge:edges){
//            dsu.union(edge[0], edge[1]);
//        }
//        for(int [] edge:edges){
//            int parent = dsu.find(edge[0]);
//            edgeCount.put(parent, edgeCount.getOrDefault(parent, 0)+1);
//        }
//        int[] vertexSize = new int[n];
//        for(int i = 0; i < n; i++) {
//            vertexSize[dsu.find(i)]++;
//        }
//        //step 2: count the number of complete components
//        int res =0;
//        for(int i=0;i<n;i++){
//            if(dsu.find(i)==i){
//                int size = vertexSize[i];
//                int expectedEdges = size*(size-1)/2;
//                int actualEdges = edgeCount.getOrDefault(i, 0);
//                if(expectedEdges==actualEdges){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//}
//class DSU{
//    int [] parent;
//    int [] rank;
//    public DSU(int n){
//        parent = new int[n];
//        rank = new int[n];
//        for(int i=0;i<n;i++){
//            parent[i]=i;
//            rank[i]=1;
//        }
//    }
//    public int find(int x){
//        if(parent[x] !=x)
//            parent[x] = find(parent[x]);
//        return parent[x];
//    }
//    public void union(int x, int y){
//        int parentX = find(x);
//        int parentY = find(y);
//        if(rank[parentX]<rank[parentY]) {
//            parent[parentX] = parentY;
//        }else if(rank[parentX]>rank[parentY]) {
//            parent[parentY] = parentX;
//        }else{
//            parent[parentY] = parentX;
//            rank[parentX]++;
//        }
//    }
//}
