package com.com.leetcode.jan;

import java.util.*;

public class MinimumCosttoConvertStringII {

    private static long MAX_VAL =1000000007;
    private static Map<String, List<Pair1>> adjList;
    private static TreeSet<Integer> set;
    private static long[] dp;
    private static String sourceStr;
    private static String targetStr;
    private static Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();
    public static void main(String[] args) {
        String source = "abcdefgh", target = "acdeeghh";
        String [] original = {"bcd","fgh","thh"}, changed = {"cde","thh","ghh"};
        int [] cost = {1,3,5};
        long minCost = minimumCostII(source, target, original, changed, cost);
        System.out.println(minCost);
    }

    private static long minimumCostII(String source, String target, String[] original, String[] changed, int [] cost) {
        sourceStr = source;
        targetStr = target;
        dp = new long[10001];
        Arrays.fill(dp, -1);
    //calculate the length of the items present in the original or changed array
        //so that while exploring the options for source string to target string, we can extend till the length present in the set
        set = new TreeSet<>();
        for(String s:original)
            set.add(s.length());
        //create the adj list which will be a directed graph
        adjList = new HashMap<>();
        for(int i=0;i< original.length;i++){
            adjList.computeIfAbsent(original[i],k->new ArrayList<>()).add(new Pair1(changed[i], cost[i]));
        }
        long result = minCostRecursion(0);
        return result==Long.MAX_VALUE?-1:result;
    }

    private static long minCostRecursion(int i) {
        //base case
        if(i>=sourceStr.length())return 0;
        if(dp[i] != -1) return dp[i];
        long minCost = Long.MAX_VALUE;
        if(sourceStr.charAt(i)==targetStr.charAt(i))
            minCost = Math.min(minCost, minCostRecursion(i + 1));
        //in case where the sourca and target str char doesnt match
        for(int len:set){
            if(i+len > sourceStr.length()) break;
            String sourceSub = sourceStr.substring(i,i+len);
            String targetSub = targetStr.substring(i,i+len);
            if(!adjList.containsKey(sourceSub)) continue;
            long cost = minCostDijkstra(sourceSub,targetSub);
            if(cost==Long.MAX_VALUE) continue;
            minCost = Math.min(minCost, cost+minCostRecursion(i+len));
        }
        return dp[i]=minCost;
    }

    private static long minCostDijkstra(String src, String dest) {
        if (dijkstraMemo.containsKey(src) &&
                dijkstraMemo.get(src).containsKey(dest)) {
            return dijkstraMemo.get(src).get(dest);
        }
        Comparator<Pair1> comparator = (p1,p2)->Long.compare(p1.cost, p2.cost);
        PriorityQueue<Pair1> pq = new PriorityQueue<>(comparator);
        Map<String,Long> res = new HashMap<>();
        res.put(src, 0L);
        pq.add(new Pair1(src, 0L));
        while(!pq.isEmpty()){
            Pair1 curr = pq.poll();
            String u = curr.str;
            Long cost = curr.cost;
            if(u.equals(dest))break;
            if(!adjList.containsKey(u))continue;
            for(Pair1 newP:adjList.getOrDefault(u, new ArrayList<>())){
                String v = newP.str;
                long newCost = newP.cost;
                long suggestedCost = cost+newCost;
                if(!res.containsKey(v) || suggestedCost<res.get(v)){
                    res.put(v, suggestedCost);
                    pq.add(new Pair1(v, suggestedCost));
                }
            }
        }
        long minCost = res.getOrDefault(dest, Long.MAX_VALUE);
        dijkstraMemo
                .computeIfAbsent(src, k -> new HashMap<>())
                .put(dest, minCost);
        return minCost;
    }

}
class Pair1{
    String str;
    long cost;
    public Pair1(String str, long cost){
        this.str = str;
        this.cost = cost;
    }
}
