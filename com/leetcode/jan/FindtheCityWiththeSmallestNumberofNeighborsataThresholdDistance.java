package com.com.leetcode.jan;

import java.util.*;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    public static void main(String[] args) {
        int n = 5;
        int [][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;
        int city = findTheCity(edges, distanceThreshold,n);
        System.out.println(city);
    }

    private static int findTheCity(int[][] edges, int distanceThreshold, int n) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        //create the adjList
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(new int[]{v,w});
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(new int[]{u,w});
        }
        int [][] distMat = new int[n][n];
        //now take a city as source and find the shortest distance from other cities
        //source =0
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int i=0;i<n;i++){
            int [] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i]=0;
            caculateShortestPath(adjList,dist,i);
            //iterate the dist and find out values less than and equal to thresold
            for(int j=0;j<n;j++){
                distMat[i][j] = dist[j];
            }
        }
        //print the dist matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(distMat[i][j]+", ");
            }
            System.out.println();
        }
        int city =-1;
        int cityCount =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currCityCount =0;
            for(int j=0;j<n;j++){
                if(distMat[i][j]<= distanceThreshold){
                    currCityCount +=1;
                }
            }
            if(currCityCount <= cityCount){
                cityCount = currCityCount;
                city = i;
            }
        }
        return city;
    }

    private static void caculateShortestPath(Map<Integer, List<int[]>> adjList, int[] dist, int i) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{i,0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int wt = curr[1];
            for(int [] cities:adjList.getOrDefault(u, new ArrayList<>())){
                int v = cities[0];
                int currWt = cities[1];
                if(currWt+wt < dist[v]){
                    dist[v] = currWt+wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
    }
}
