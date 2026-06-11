package com.com.leetcode.june;

import java.util.*;

public class NumberofWaystoAssignEdgeWeightsI {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int [][] edges = {{1,2}};
        int res = assignEdgeWeights(edges);
        System.out.println(res);
    }

    private static int assignEdgeWeights(int[][] edges) {
        //find n

        //build adj list of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int [] edge:edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int n = graph.size();
        if(n==0)return 0;
        boolean[] visited = new boolean[n];
        //calculate the max depth
        int l = dfsII(1,0, graph, visited, n);
        int res = (int) (Math.pow(2, l-1) % MOD);
        return res;
    }

    private static int dfsII(int curr, int currDepth, Map<Integer, List<Integer>> graph, boolean[] visited, int n) {
        visited[curr-1] = true;
        int maxDepth = currDepth;
        for(int neighbor: graph.get(curr)){
            if(!visited[neighbor-1]){
                maxDepth = Math.max(maxDepth, dfsII(neighbor, currDepth+1, graph, visited, n));
            }
        }
        return maxDepth;
    }

}
