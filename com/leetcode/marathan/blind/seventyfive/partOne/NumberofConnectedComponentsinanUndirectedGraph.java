package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofConnectedComponentsinanUndirectedGraph {
    public static void main(String[] args) {
        int n = 2;
        int [][] edges = {{1,0}};
        int count = countComponents(edges,n);
        System.out.println(count);
    }

    private static int countComponents(int[][] edges, int n) {
        //prepare the adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        boolean [] vistied = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vistied[i]){
                count +=1;
                countComponentsDFS(adjList,vistied,i,-1);
            }
        }
        return count;
    }

    private static void countComponentsDFS(Map<Integer, List<Integer>> adjList, boolean[] vistied, int u, int parent) {
        //base condition
        if(vistied[u]) return;
        vistied[u] = true;
        for(int v : adjList.getOrDefault(u,new ArrayList<>())){
            if(v==parent)continue;
            else if(!vistied[v])
                countComponentsDFS(adjList,vistied,v,u);
        }
    }
}
