package com.com.leetcode.july;

import java.util.*;

public class MinimumScoreofaPathBetweenTwoCities {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,2},{1,3,4},{3,4,7}};
        int res = minScore(n, roads);
        System.out.println(res);
    }

    private static int minScore(int n, int[][] roads) {
        //create the adjacency list
        Map<Integer, List<int[]>> adjList = new java.util.HashMap<>();
        for(int [] road:roads){
            int u = road[0];
            int v = road[1];
            int score = road[2];
            adjList.computeIfAbsent((u-1), k-> new ArrayList<>()).add(new int[]{v-1,score});
            adjList.computeIfAbsent((v-1), k-> new ArrayList<>()).add(new int[]{u-1,score});
        }
        int minScore = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,Integer.MAX_VALUE});
        //now perform dijkstra's algorithm to find the minimum score path from city 1 to city n
        boolean [] visited = new boolean[n];
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int u = arr[0];
            int score = arr[1];
            if(visited[u])continue;
            visited[u] = true;
            minScore = Math.min(minScore,score);
            for(int [] neighbor:adjList.getOrDefault(u,new ArrayList<>())){
                int v = neighbor[0];
                int edgeScore = neighbor[1];
                if(!visited[v]){
                    pq.offer(new int[]{v,edgeScore});
                }
            }
        }
       return minScore;
    }
}
