package com.com.leetcode.jan;

import java.util.*;

public class MinimumCosttoConvertStringI {
    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char [] original = {'a','b','c','c','e','d'}, changed = {'b','c','b','e','b','e'};
        int [] cost = {2,5,5,1,2,20};
        long minCost = minimumCost(source, target, original, changed, cost);
        System.out.println(minCost);
    }

    private static long minimumCost(String source, String target, char[] original, char[] changed, int [] cost) {
        int strLen = source.length();
        int n = original.length;
        //now create the adjlist
        Map<Character, List<Pair>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.computeIfAbsent(original[i], k->new ArrayList<>()).add(new Pair(cost[i], changed[i]));
        }
        //create a cahce to store the result for all 26 char
        long[][] cache = new long[26][26];
        for(long[] c:cache)
            Arrays.fill(c, -1);
        long mincost=0;
        //start traversing the source and dest string
        //parse char by char as src and dest
        for(int i=0;i<strLen;i++){
            char src = source.charAt(i);
            char dest = target.charAt(i);
            int srcIdx = src - 'a';
            int destIdx = dest - 'a';
            //if(src==dest)mincost +=0;
            if(cache[srcIdx][0]==-1){
                long[] distance = new long[26];
                Arrays.fill(distance, Long.MAX_VALUE);
                calculateMinCostWithDijkstra(adjList, src, distance);
                // Store the entire result row in our cache
                cache[srcIdx] = distance;
            }
            long calculated_cost = cache[srcIdx][destIdx];
            if(calculated_cost==Long.MAX_VALUE)return -1;
            mincost +=calculated_cost;
        }
        return mincost;
    }

    private static void calculateMinCostWithDijkstra(Map<Character, List<Pair>> adjList, char src, long[] distance) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost, b.cost));
        distance[src-'a']=0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            long cost = pair.cost;
            char u = pair.node;
            if(cost > distance[u-'a'])continue;
            for(Pair p:adjList.getOrDefault(u,new ArrayList<>())){
                long newCost = p.cost;
                char v = p.node;
                long updatedCost = cost+newCost;
                if(updatedCost < distance[v-'a']){
                    distance[v-'a'] = updatedCost;
                    pq.add(new Pair(updatedCost, v));
                }
            }
        }
    }
}
class Pair{
    long cost ;
    char node;

    public Pair(long cost, char node){
        this.cost = cost;
        this.node = node;
    }
}
