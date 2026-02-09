package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> q;
    public RecentCounter(){
        q = new LinkedList<>();
    }
    public int ping(int t){
        q.add(t);
        int lowerBound = t-3000;
        if(lowerBound <=1) return q.size();
        while(!q.isEmpty() && q.peek() <lowerBound){
            q.poll();
        }
        return q.size();
    }
}
