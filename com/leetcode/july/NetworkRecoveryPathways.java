package com.com.leetcode.july;

import java.util.*;

public class NetworkRecoveryPathways {
    public static void main(String[] args) {
        int [][] edges = {{0,1,7},{1,4,5},{0,2,6},{2,3,6},{3,4,2},{2,4,6}};
        int k = 12;
        boolean [] online = {true,true,true,false,true};
        int maxScore = findMaxPathScore(edges, k, online);
        System.out.println(maxScore);
    }

    private static int findMaxPathScore(int[][] edges, int k, boolean[] online) {
        int n = online.length;
        Map<Integer, List<int[]>> adjList = new java.util.HashMap<>();
        //if the node is online, add it to the adjacency list
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int score = edge[2];
            if(!online[u] || !online[v])continue;
            adjList.computeIfAbsent(u, key->new java.util.ArrayList<>()).add(new int[]{v,score});
        }
        //start the minimum spanning tree algorithm using Prim's algorithm
        int maxScore = -1;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
       //take a map to keep track of cost involvd in each path
         Map<int[], Integer> costMap = new HashMap<>();
         Map<Integer, List<Integer>> pathEdgeMap = new HashMap<>();

        //TODO impleent it
        return 1;
    }
}
