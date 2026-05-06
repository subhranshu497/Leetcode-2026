package com.com.leetcode.may;

import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<Interval>> schedule = List.of(
                List.of(new Interval(1, 2), new Interval(5, 6)),
                List.of(new Interval(1, 3)),
                List.of(new Interval(4, 10))
        );
        EmployeeFreeTime obj = new EmployeeFreeTime();
        List<Interval> res = obj.employeeFreeTime(schedule);
        for(Interval i: res) {
            System.out.println(i.start+" "+i.end);
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        //comparator to sort based on start time if strat time is same then sort based on end time
        Comparator<Interval> comparator = Comparator.comparingInt((Interval i)-> i.start)
                .thenComparingInt(i ->i.end);
        List<Interval> flattened = schedule.stream().flatMap(List::stream)
                .sorted(comparator)
                .toList();
        List<Interval> res = new java.util.ArrayList<>();
        int prevEnd = flattened.get(0).end;
        for(int i=1; i<flattened.size(); i++) {
            Interval curr = flattened.get(i);
            if(prevEnd < curr.start)
                res.add(new Interval(prevEnd, curr.start));
            prevEnd = Math.max(prevEnd, curr.end);
        }
        return res;
    }
}
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
