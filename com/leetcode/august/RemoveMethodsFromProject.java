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
        int [] indegree = new int[n];
        for(int [] invocation:invocations){
            int u = invocation[0];
            int v = invocation[1];
            adjList.computeIfAbsent(u, lambda->new ArrayList<>()).add(v);
            indegree[v]++;
        }
        //start the dfs from buggy node
        boolean [] visited = new boolean[n];
        remainingMethodsDFS(adjList,k,indegree, visited);

        //now check if any of the visited nodes which are infected have indegree > 1, set removeNode flag to true,
        //else if zero , then no node removal is needed return
        boolean cannotRemove = false;
        for(int i=0;i<n;i++){
            if(visited[i] && indegree[i]>0){
                cannotRemove = true;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cannotRemove || !visited[i])res.add(i);
        }
        return res;
    }

    private static void remainingMethodsDFS(Map<Integer, List<Integer>> adjList, int u, int[] indegree, boolean[] visited) {
        //base case
        if(visited[u])return;
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            indegree[v]--;
            remainingMethodsDFS(adjList,v,indegree,visited);
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
