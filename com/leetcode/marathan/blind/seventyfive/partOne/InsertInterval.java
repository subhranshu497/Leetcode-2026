package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class InsertInterval {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        int [][] res = insertI(intervals, newInterval);
        for(int [] r:res)
            System.out.print("(" +r[0]+","+r[1]+")"+" , ");
    }

    private static int[][] insertI(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i =0;
        int n = intervals.length;
        //case-1 - all intervals end before new interval start
        while(i<n && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //case -2 - merge the overlap
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        //case 3 - all intervals starts on or after newinterval
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
