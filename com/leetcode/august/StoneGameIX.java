package com.com.leetcode.august;

import java.util.Arrays;
import java.util.Map;

public class StoneGameIX {
    public static void main(String[] args) {
        int [] stones = {5,1,2,4,3};
        boolean flag = stoneGameIX(stones);
        System.out.println(flag);
    }

    private static boolean stoneGameIX(int[] stones) {
        int [] count = new int[3];
        for(int stone:stones){
            count[stone%3]++;
        }
        int a = count[1];
        int b = count[2];
        int c = count[0];
        if(c%2==0){
            return a>0 && b>0;
        }

        return Math.abs(a-b)>2;
    }
}
