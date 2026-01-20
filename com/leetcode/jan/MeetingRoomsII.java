package com.com.leetcode.jan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int [][] intervals = {{7,10},{2,4}};
        int rooms = minMeetingRooms(intervals);
        System.out.println(rooms);
    }

    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 0;
        for(int [] interval :intervals){
            int sttime = interval[0];
            int endTime = interval[1];
            if(!pq.isEmpty() && pq.peek() <= sttime){
                pq.poll();
            }
            pq.add(endTime);
        }
        return pq.size();
    }
}
