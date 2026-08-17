package com.com.practice.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int [][] intervals = {{2,11},{6,16},{11,16}};
        int res = minMeetingRoomsII(intervals);
        System.out.println(res);
    }

    private static int minMeetingRoomsII(int[][] intervals) {
        //write a comparator, increasing order of 0th pos , if 0th pos same then decreasing order of 1st pos
        Comparator<int[]> comparator = Comparator.<int[]>comparingInt(a->a[0])
                .thenComparing(b->b[1], Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, comparator);
        for(int [] interval:intervals){
            if(!pq.isEmpty() && pq.peek() <= interval[0])pq.poll();
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}
