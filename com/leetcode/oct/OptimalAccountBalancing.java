package com.com.leetcode.oct;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        int [][] transactions = {{0,1,10},{2,0,5}};
        int noOfTrnx = minTransfers(transactions);
        System.out.println(noOfTrnx);
    }

    private static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        int[] debt = new int[m.size()];
        int i=0;
        for(int d:m.values()){
            debt[i] =d;
            i++;
        }
        return settle(0, debt);
    }
    private static int settle(int start, int[] debt) {
        while (start < debt.length && debt[start] == 0){
            start++;
        }
        if (start == debt.length) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.length; i++){
            if (debt[start] * debt[i] < 0) {    //opposite sign
                debt[i] = debt[i] + debt[start];
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt[i] = debt[i] - debt[start];
            }
        }
        return r;
    }
}
