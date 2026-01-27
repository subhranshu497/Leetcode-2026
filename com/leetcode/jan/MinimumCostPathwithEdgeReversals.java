package com.com.leetcode.jan;

import java.util.*;

public class MinimumCostPathwithEdgeReversals {
    public static void main(String[] args) {
        int [][] edges = {{0,1,3},{3,1,1},{2,3,4},{0,2,2}};
        int n =4;
        int cost = minCost(edges,n);
        System.out.println(cost);
    }

    private static int minCost(int[][] edges, int n) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        //build the adj list
        for(int[] edge:edges){
            int u= edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(new int[]{v,wt});
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(new int[]{u,2*wt});
        }
        //define a distance array and intialize it with max value , as the distance between src and node is unknown at the begining
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        //take a min heap and sort it based on the wt
        Comparator<int[]> comparator = (a, b)-> Integer.compare(a[1], b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int u = curr[0];
            int wt = curr[1];
            for(int[] nei:adjList.getOrDefault(u, new ArrayList<>())){
                int v = nei[0];
                int v_wt = nei[1];
                if(dist[v]>(wt+v_wt)){
                    dist[v] = wt+v_wt;
                    pq.add(new int[]{v, wt+v_wt});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE?-1:dist[n-1];
    }
}
