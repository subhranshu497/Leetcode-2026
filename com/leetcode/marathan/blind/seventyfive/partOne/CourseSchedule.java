package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {
        int [][] prerequisites = {{1,0}};
        int numCourses =2;
        boolean flag = canFinish(prerequisites, numCourses);
        System.out.println(flag);
    }

    private static boolean canFinish(int[][] prerequisites, int numCourses) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] pre:prerequisites){
            int u = pre[1];
            int v = pre[0];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] inRecursion = new boolean[numCourses];
        boolean flag = false;
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && hasCycle(adjList, visited, inRecursion, i)) return false;
        }
        return true;
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] inRecursion, int u) {
        visited[u] = true;
        inRecursion[u] =  true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v] && hasCycle(adjList,visited,inRecursion,v))return true;
            else if (inRecursion[v]) return true;
        }
        inRecursion[u] = false;
        return false;
    }
}
