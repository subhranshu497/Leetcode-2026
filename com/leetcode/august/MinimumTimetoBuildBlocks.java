package com.com.leetcode.august;

import java.util.PriorityQueue;

public class MinimumTimetoBuildBlocks {
    public static void main(String[] args) {
        int [] blocks = {1,2,3};
        int split =1;
        int ans = minBuildTime(blocks, split);
        System.out.println(ans);
    }

    private static int minBuildTime(int[] blocks, int split) {
        int n = blocks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add to the pq
        for(int block:blocks)
            pq.offer(block);
        // pick two smallest block , then calculate the min time to build it
        //i.e. the max of two and then do the split
        //push to pq and repeat
        while (pq.size()>=2){
            int t1 = pq.poll();
            int t2 = pq.poll();
            int minTime  = Math.max(t1, t2);
            int t = minTime+split;
            pq.add(t);
        }
        return pq.peek();
    }
}
