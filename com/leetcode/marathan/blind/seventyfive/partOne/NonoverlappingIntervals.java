package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,2},{1,2},{1,2}};
        int count = eraseOverlapIntervals(intervals);
        System.out.println(count);
    }

    private static int eraseOverlapIntervals(int[][] intervals) {

        Comparator<int[]> comparator = (int [] a,int[] b)->{
            return Integer.compare(a[1], b[1]);
        };
        Arrays.sort(intervals, comparator);
        int count =0;
        int n = intervals.length;
        if(n==1) return count;
        int prevEnd = intervals[0][1];
        int prevSt = intervals[0][0];
        int j = 1;
        while(j<n){
            int currSt = intervals[j][0];
            int currEnd = intervals[j][1];
            if(prevEnd > currSt){
                count +=1;
                //remove the interval which ends later, because
                //the interval which ends later, more likely it will create the overlap
            }
            else prevEnd = currEnd;
            j++;
        }
        return count;
    }
}
