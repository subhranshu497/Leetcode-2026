package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));    // Room 0
        rooms.add(Arrays.asList(3, 0, 1)); // Room 1
        rooms.add(Arrays.asList(2));       // Room 2
        rooms.add(Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited = new boolean[n];
        //start dfs
        visitRoomsAndKeysDFS(rooms, visited, 0);

        //check for unexplored room
        for(int i =0;i<n;i++){
            if(!visited[i])return false;
        }
        return true;
    }

    private static void visitRoomsAndKeysDFS(List<List<Integer>> rooms, boolean[] visited, int u) {
        //base case
        if(visited[u])return;
        visited[u] = true;
        for(int v:rooms.get(u)){
            visitRoomsAndKeysDFS(rooms, visited, v);
        }
    }
}
