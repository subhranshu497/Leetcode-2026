package com.com.leetcode.july;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,4},{3,6},{2,8}};
        int res = removeCoveredIntervals(intervals);
        System.out.println(res);
    }

    private static int removeCoveredIntervals(int[][] intervals) {
        int count =0;
        Arrays.sort(intervals, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int maxEnd =0;
        for(int [] interval:intervals){
            if(interval[1]>maxEnd){
                maxEnd = interval[1];
                count++;
            }
        }
        return count;
    }
}
