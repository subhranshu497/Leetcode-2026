package com.com.leetcode.feb;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RearrangeStringkDistanceApart {
    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 3;
        String res = rearrangeString(s, k);
        System.out.println(res);
    }

    private static String rearrangeString(String s, int k) {
        Map<Character,Integer> freq = new ConcurrentHashMap<>();
        if(k<=1)return s;
        for(char c : s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        pq.addAll(freq.keySet());
        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()){
            char currch = pq.poll();
            res.append(currch);
            freq.put(currch,freq.get(currch)-1);
            waitQueue.offer(currch);
            if(waitQueue.size() >=k){
                char front = waitQueue.poll();
                if(freq.get(front)>0){
                    pq.offer(front);
                }
            }
        }
        return res.toString().length()==s.length() ? res.toString() : "";
    }
}
