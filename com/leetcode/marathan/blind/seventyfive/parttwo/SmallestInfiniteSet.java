package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    int nextSmallest;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest=1;
    }

    public int popSmallest() {
        while(!pq.isEmpty()){
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if(num<nextSmallest && set.add(num))
            pq.add(num);
    }
}
