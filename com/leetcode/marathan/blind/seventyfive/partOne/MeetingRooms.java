package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        boolean flag = canAttendMeetings(intervals);
        System.out.println(flag);
    }

    private static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0) return true;
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));
        int prevStTime = intervals[0][0];
        int prevEndTime = intervals[0][1];
        for(int i=1;i< intervals.length;i++){
            int currStTime = intervals[i][0];
            int currEndTime = intervals[i][1];
            if(prevEndTime> currStTime) return false;
            prevEndTime = currEndTime;
        }
        return true;
    }
}
