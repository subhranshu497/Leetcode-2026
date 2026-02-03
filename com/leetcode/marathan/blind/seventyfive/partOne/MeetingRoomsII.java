package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int [][] intervals = {{7,10},{2,4}};
        int minRooms = minMeetingRoomsI(intervals);
        System.out.println(minRooms);
    }

    private static int minMeetingRoomsI(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));
        PriorityQueue<int[]> rooms= new PriorityQueue<>(Comparator.comparing(a->a[1]));
        int count =0;
        int i =0;
        int n = intervals.length;
        while(i<n){
           if(rooms.isEmpty()){
               rooms.add(new int []{intervals[i][0], intervals[i][1]});
           }else{
               if(rooms.peek()[1]<= intervals[i][0]){
                   rooms.poll();
               }
               rooms.add(new int []{intervals[i][0], intervals[i][1]});
           }
           i++;
        }
        return rooms.size();
    }
}
