package com.leetcode.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int n = 2;
        int [][] reservedSeats = {{2,1},{1,8},{2,6}};
        int max = maxNumberOfFamilies(reservedSeats,n);
        System.out.println(max);
    }

    private static int maxNumberOfFamilies(int[][] reservedSeats, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] rs:reservedSeats){
            int row = rs[0];
            int seat = rs[1];
            int mask = 1<<seat;
            map.put(row, mask);
        }
        int res = n-map.size();
        int groupAMask = (1<<2) | (1<<3) | (1<<4) | (1<<5);
        int groupBMask = (1<<4) | (1<<5) | (1<<6) | (1<<7);
        int groupCMask = (1<<6) | (1<<7) | (1<<8) | (1<<9);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int bookedSeatsMask = entry.getValue();

            boolean groupA = (bookedSeatsMask & groupAMask) == 0;
            boolean groupB = (bookedSeatsMask & groupAMask) == 0;
            boolean groupC = (bookedSeatsMask & groupAMask) == 0;

            if(groupA && groupC)
                res += 2;
            else if(groupA || groupB || groupC)
                res += 1;
        }

        return res;
    }

//    private static int maxNumberOfFamilies(int[][] reservedSeats, int n) {
//        Map<Integer, Set<Integer>> seats = new HashMap<>();
//        int availableSeats = 0;
//        for(int [] reservedSeat:reservedSeats){
//            seats.computeIfAbsent(reservedSeat[0], k->new HashSet<>()).add(reservedSeat[1]);
//        }
//        int emptyRows = n-seats.size();
//        availableSeats = emptyRows*2;
//        //group A = 2,3,4,5
//        //group B = 4,5,6,7
//        //group C = 6,7,8,9
//        for(Map.Entry<Integer, Set<Integer>> e:seats.entrySet()){
//            int row= e.getKey();
//            Set<Integer> set = e.getValue();
//            boolean groupA = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);
//            boolean groupB = !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);
//            boolean groupC = !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);
//            if(groupA && groupC) availableSeats +=2;
//            else{
//                if(groupA || groupB || groupC) availableSeats +=1;
//            }
//        }
//
//        return availableSeats;
//    }
}
