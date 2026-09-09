package com.com.leetcode.sept;

public class CountCommasinRangeII {
    public static void main(String[] args) {
        int n =1002;
        long res = countCommasI(n);
        System.out.println(res);
    }

    private static long countCommasI(int n) {
        long totalCommas = 0;
        long threshold = 1000;
        while(n>=threshold){
            totalCommas +=(n-threshold+1);
            threshold *=1000;
        }
        return totalCommas;
    }
}
