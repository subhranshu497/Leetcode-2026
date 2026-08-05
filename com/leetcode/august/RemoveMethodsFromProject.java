package com.com.leetcode.august;

import java.util.*;

public class RemoveMethodsFromProject {
    public static void main(String[] args) {
        int n = 4, k =1;
        int [][] invocations = {{1,2},{0,1},{3,2}};
        List<Integer> res = remainingMethods(n,k,invocations);
        System.out.println(res);
    }

    private static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
            res.add(i);
        int[] inDegree = new int[n];
        for(int [] invocation:invocations){
            int u = invocation[0];
            int v = invocation[1];
            adjList.computeIfAbsent(u,lambda->new ArrayList<>()).add(v);
            inDegree[v]++;
        }
        //if(inDegree[k] !=0) return res;
        res.clear();
        //else do the dfs
        boolean [] visited = new boolean[n];
        //start dfs from k
        remainingMethodsRecursion(k,adjList,visited);
        Set<Integer> good = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited[i])good.add(i);
        }
        //now start removing
        for(int i =0;i<n;i++){
            if(good.contains(i))res.add(i);
        }
        return res;
    }

    private static void remainingMethodsRecursion(int u, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        //base case
        if(visited[u])return;
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            remainingMethodsRecursion(v, adjList,visited);
        }
    }

    /**
     * 1-->2
     * 0 -->1
     * 3-->2
     * @param n
     * @param k
     * @param invocations
     * @return
     */

//    private static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
//        Map<Integer, List<Integer>> adjList = new HashMap<>();
//        for(int [] invocation:invocations){
//            int methodOne = invocation[0];
//            int methodTwo = invocation[1];
//            adjList.computeIfAbsent(methodOne, lambda->new ArrayList<>()).add(methodTwo);
//        }
//      boolean  visited [] = new boolean[n];
//        //lets do dfs from the buggy k
//        remainingMethodsDFS(k,visited,adjList);
//        for(int [] invocation:invocations){
//            int u = invocation[0];
//            int v = invocation[1];
//            if(visited[u]) continue;
//            if(visited[v]){
//                List<Integer> ans = new ArrayList<>();
//                for (int i = 0; i < n; i++) {
//                    ans.add(i);
//                }
//                return ans;
//            }
//        }
//        List<Integer> ans = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                ans.add(i);
//            }
//        }
//
//        return ans;
//    }
//
//    private static void remainingMethodsDFS(int u, boolean[] visited, Map<Integer, List<Integer>> adjList) {
//        //base case
//        if(visited[u]) return;
//        visited[u] = true;
//        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
//            if(visited[v]) continue;
//            remainingMethodsDFS(v,visited,adjList);
//        }
//    }
}
