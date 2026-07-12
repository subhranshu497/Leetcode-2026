package com.com.leetcode.july;

import java.util.*;

public class PathExistenceQueriesinaGraphI {
    public static void main(String[] args) {
        int n = 4;
        int [] nums = {2,5,6,8};
        int maxDiff = 2;
        int [][] queries = {{0,1},{0,2},{1,3},{2,3}};
        boolean [] res = pathExistenceQueries(n, nums, maxDiff, queries);
        for(boolean b:res){
            System.out.println(b);
        }
    }

    private static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int [] component = new int[n];
        Arrays.fill(component, -1);
        component[0] =0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff) {
                component[i] = component[i - 1];
            }else component[i] = component[i-1]+1;
        }
        boolean [] res = new boolean[queries.length];
        //now traverse the query
        int i=0;
        for(int [] query:queries){
            int u = query[0];
            int v = query[1];
            res[i++] = component[u]==component[v];
        }
        return res;
    }

    //solve using union find
//    private static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
//        //create the adj list
//        DSU dsu = new DSU(n);
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(Math.abs(nums[i]-nums[j])<=maxDiff){
//                    dsu.union(i,j);
//                }
//            }
//        }
//        boolean [] res = new boolean[queries.length];
//        for(int i=0;i<queries.length;i++){
//            int u = queries[i][0];
//            int v = queries[i][1];
//            res[i] = dsu.find(u)==dsu.find(v);
//        }
//        return res;
//    }
//    }
//
//class DSU{
//        int [] parent;
//        int [] rank;
//        public DSU(int n){
//            rank = new int[n];
//            parent = new int[n];
//            for(int i=0;i<n;i++){
//                parent[i] =i;
//                rank[i] =1;
//            }
//        }
//        public int find(int x){
//            if(parent[x] != x){
//                parent[x] =find(parent[x]);
//            }
//            return parent[x];
//        }
//        public void union(int x, int y){
//            int parentX = find(x);
//            int parentY = find(y);
//            if(parentX==parentY)return;
//            if(rank[parentX]<rank[parentY]) {
//                parent[parentX] = parentY;
//            }else if(rank[parentX]>rank[parentY]) {
//                parent[parentY] = parentX;
//            }
//            else{
//                parent[parentY] = parentX;
//                rank[parentX]++;
//        }
//}
    //brute force - TLE

//    private static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
//        //step 1 - create the adj list from the nums array
//        Map<Integer, List<Integer>> adjList = new HashMap<>();
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(Math.abs(nums[i]-nums[j])<=maxDiff){
//                    adjList.computeIfAbsent(i, k->new java.util.ArrayList<>()).add(j);
//                    adjList.computeIfAbsent(j, k->new java.util.ArrayList<>()).add(i);
//                }
//            }
//        }
//        //step 2 - for each query, check if there is a path between the two nodes using DFS
//        boolean [] res = new boolean[queries.length];
//        int i=0;
//        for(int [] query:queries){
//            int u = query[0];
//            int v = query[1];
//            if(u==v){
//                res[i] = true;
//                i++;
//                continue;
//            }
//            if(adjList.get(u)==null || adjList.get(v)==null){
//                res[i] = false;
//                i++;
//                continue;
//            }
//            boolean[] visited = new boolean[n];
//            res[i] = pathExistenceQueriesDfs(adjList, u, v, visited);
//            i++;
//        }
//        return res;
//    }
//
//    private static boolean pathExistenceQueriesDfs(Map<Integer, List<Integer>> adjList, int u, int v, boolean[] visited) {
//        if(u==v)return true;
//        visited[u] = true;
//        for(int ne:adjList.getOrDefault(u, new ArrayList<>())){
//            if(!visited[ne]){
//                if(pathExistenceQueriesDfs(adjList, ne, v, visited))return true;
//            }
//        }
//        return false;
//    }
}
