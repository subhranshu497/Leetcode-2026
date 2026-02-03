package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String [] words = {"z","z"};
        String res = alienOrder(words);
        System.out.println("res "+res);
    }

    private static String alienOrder(String[] words) {
        int n =words.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(String word:words){
            for(int i=0;i<word.length();i++){
                set.add(word.charAt(i));
            }
        }
        //compare the alien words pair by pair
        for(int i=0;i<n-1;i++){
            String prevWord = words[i];
            String currWord = words[i+1];
            if(prevWord.length()>currWord.length() && prevWord.startsWith(currWord)) return "";
            //start the comparision for inequality
            int len = Math.min(prevWord.length(), currWord.length());
            for(int j=0;j<len;j++){
                if(prevWord.charAt(j) !=currWord.charAt(j)){
                    int src = prevWord.charAt(j)-'a';
                    int dest = currWord.charAt(j)-'a';
                    adjList.computeIfAbsent(src, k->new ArrayList<>()).add(dest);
                    break;
                }
            }
        }
        System.out.println(adjList);
        //adj list is done
        //before applying topossort check if there is a cycle in the graph
        //in case of cycle flag = true
        boolean flag = false;
        boolean [] visited = new boolean[26];
        boolean [] inRecursion = new boolean[26];
        System.out.println(set);
        for(char ch:set){
            if(!visited[ch-'a'] && checkForCycle(set, adjList, visited, ch-'a', inRecursion)){
                flag = true;
            }
        }
        System.out.println("It is "+flag);
        if(flag) return "";
        //do topological sort

        Stack<Integer> st = new Stack<>();
        visited = new boolean[26];
        for(char ch :set){
            int charIdx = ch-'a';
            if(!visited[charIdx]){
                findTopologicalSort(visited, adjList, set, charIdx,st);
            }
        }
        //get the index from stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            char ch = (char) (st.pop()+'a');
            sb.append(ch);
        }
        return sb.toString();
    }

    private static boolean checkForCycle(Set<Character> set, Map<Integer, List<Integer>> adjList, boolean[] visited, int u, boolean [] inRecursion) {
        //base condition
        if(visited[u]) return false;
        visited[u] = true;
        inRecursion[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(inRecursion[v])return true;
            if(!visited[v]){
                if(checkForCycle(set,adjList,visited,v,inRecursion)) return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }

    private static void findTopologicalSort(boolean[] visited, Map<Integer, List<Integer>> adjList, Set<Character> set, int u, Stack<Integer> st) {
        //base condition
        if(visited[u]) return;
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v]){
                findTopologicalSort(visited,adjList,set,v,st);
            }
        }
        st.push(u);
    }
}
