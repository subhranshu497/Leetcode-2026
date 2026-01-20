package com.com.leetcode.concept.graph;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        int time = networkDelayTime(times, n, k);
        System.out.println(time);
    }

    private static int networkDelayTime(int[][] times, int n, int k) {
        //create the adj list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int [] time:times){
            adjList.computeIfAbsent(time[0]-1, lam->new ArrayList<>()).add(new int []{time[2], time[1]-1});
        }
        //to calculate the shortest distance we need a min heap and store the data based on the distance
        //initially the distance from k node is infinitte
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.add(new int []{0,k-1});
        while (!pq.isEmpty()){
            int [] curr = pq.poll();
            int wt = curr[0];
            int u = curr[1];
            for(int [] arr:adjList.getOrDefault(u, new ArrayList<>())){
                int currWt = arr[0];
                int v = arr[1];
                if(wt+ currWt < dist[v]){
                    dist[v] = wt+currWt;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int d:dist){
            System.out.println(d);
            minTime = Math.max(d, minTime);
        }

        return minTime==Integer.MAX_VALUE?-1:minTime;
    }
}
