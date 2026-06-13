package com.com.leetcode.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofWaystoAssignEdgeWeightsII {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,3},{3,4},{3,5}};
        int [][] queries ={{1,4},{3,4},{2,5}};
        int[] res = assignEdgeWeightsII(edges, queries);
        for (int r: res) {
            System.out.print(r + " ");
        }
    }

    private static int[] assignEdgeWeightsII(int[][] edges, int[][] queries) {
        //step -1 prepare the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new java.util.ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new java.util.ArrayList<>()).add(u);
        }
        //step -2 - find the parent of each node and the depth of each node
        //now start iterating over queries
        int[] res = new int[queries.length];
        int i=0;
        for(int [] query:queries){
            int u = query[0];
            int v = query[1];
            //find the max height between u and v
             int maxHeight = findMaxHeight(-1,u, v, graph);
            //using binary exponentiation calculate the number of ways to assign edge weights
            int ways = powerI(2, maxHeight-1);
            res[i++] = ways;
        }
        return res;
    }

    private static int powerI(int base, int exp) {
        if(exp <0) return 0;
      long res = 1;
      base = base % MOD;
      while(exp >0){
          if(exp % 2 ==1){
              res = (res * base) % MOD;
          }
          base = (base * base) % MOD;
            exp = exp >> 1;
      }
      return (int) res;
    }

    private static int findMaxHeight(int parent, int u, int v, Map<Integer, List<Integer>> graph) {
        if(u == v)return 0;
        int height =-1;
        //start exploring the neighbors of u
        for(int nei:graph.getOrDefault(u, new ArrayList<>())){
            if(nei == parent)continue;
            int currHeight = findMaxHeight(u, nei, v, graph);
            if(currHeight != -1){
                height = Math.max(height, currHeight+1);
            }
        }
        return height;
    }
}
