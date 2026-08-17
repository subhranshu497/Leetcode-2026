package com.com.geeksfor.geeks;

import java.util.*;

public class MergeandSortIntervals {
    public static void main(String[] args) {
        List<List<Integer>> intervals = List.of(
                List.of(1, 3),
                List.of(2, 6),
                List.of(4, 5),
                List.of(8, 10),
                List.of(15, 18)
        );
        List<List<Integer>> res = mergeHighDefinitionIntervals(intervals);
        System.out.println(res);
    }

    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
        List<List<Integer>> res = new ArrayList<>();
        //write a comparator to sort the interval accending order of start time and if start time are same then desending order of endtime
        //edge case
        if(intervals.size()==0) return res;
        if(intervals.size()==1) return intervals;
        //write the comparator as mentioned above
        Comparator<List<Integer>> comparator = Comparator.<List<Integer>, Integer>comparing(a->a.get(0))
                .thenComparing((a,b)->Integer.compare(b.get(1),a.get(1)));
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(comparator);
        //first put all the interval to priorityqueue
        for(List<Integer> l:intervals){
            pq.add(l);
        }
        List<Integer> interval1 = pq.poll();
        List<Integer> interval2 = pq.poll();
        int startTime1 = interval1.get(0);
        int endTime1 = interval1.get(1);
        int startTime2 = interval2.get(0);
        int endTime2 = interval2.get(1);
        while(!pq.isEmpty()){
            while(endTime1 >= startTime2){
                if(endTime1 <= endTime2){
                    endTime1 = endTime2;
                }
                if(!pq.isEmpty()){
                    List<Integer> interval = pq.poll();
                    startTime2 = interval.get(0);
                    endTime2 = interval.get(1);
                }else break;


            }
            List<Integer> l = new ArrayList<>();
            l.add(startTime1);
            l.add(endTime1);
            startTime1 = startTime2;
            endTime1 = endTime2;
            res.add(l);
            if(endTime1 < startTime2){
                startTime1 = startTime2;
                endTime1 = endTime2;
                if(!pq.isEmpty()){
                    List<Integer> interval = pq.poll();
                    startTime2 = interval.get(0);
                    endTime2 = interval.get(1);
                }
            }
        }
        if(endTime1 >= startTime2){
            endTime1 = Math.max(endTime1, endTime2);
            res.add(List.of(startTime1,endTime1));
        }else {
            res.add(List.of(startTime1,endTime1));
            res.add(List.of(startTime2,endTime2));
        }
        return res;
    }
}
