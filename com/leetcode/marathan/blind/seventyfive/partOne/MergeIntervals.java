package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,4},{5,6}};
        int[][] res =  merge(intervals);
        for(int [] r:res){
            System.out.println(r[0]+", "+r[1]);
        }

    }

    private static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        Comparator c = Comparator.comparingInt((int [] a)->a[0])
                .thenComparing(a->a[1]);
        Arrays.sort(intervals, c);
        List<int[]> res = new ArrayList<>();
        int [] prev = intervals[0];
        res.add(prev);
        for(int i=1;i<n;i++){
            int prevEndTime = prev[1];
            int currStTime = intervals[i][0];
            int currEndTime = intervals[i][1];
            if(prevEndTime >= currStTime){
                prev[1] = Math.max(prevEndTime, currEndTime);
            }else {
                prev = intervals[i];
                res.add(new int [] {intervals[i][0], intervals[i][1]});
            }
        }
        return res.stream().toArray(int[][]::new);
    }
}
