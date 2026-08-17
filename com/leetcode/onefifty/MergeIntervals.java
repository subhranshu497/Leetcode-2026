package com.com.leetcode.onefifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] res = mergeIII(intervals);
        for(int [] re:res){
            System.out.println("Start time = "+re[0]+"   "+"End Time = "+re[1]);
        }
    }

    private static int[][] mergeIII(int[][] intervals) {
        Comparator comparator = Comparator.comparingInt((int [] a)->a[0])
                .thenComparing((int[] b)->b[1]);
        Arrays.sort(intervals, comparator);
        int n =intervals.length;
        int st1 = intervals[0][0];
        int et1 = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            int st2 = intervals[i][0];
            int et2 = intervals[i][1];
            if(et1 >=st2){
                et1 = Math.max(et2,et1);
            }else {
                list.add(List.of(st1, et1));
                st1 = st2;
                et1 = et2;
            }
        }
        list.add(List.of(st1, et1));
        int [][] res = list.stream()
                .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return res;

    }
}
