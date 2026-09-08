package com.com.leetcode.sept;

public class CountCommasinRange {
    public static void main(String[] args) {
        int n = 998;
        int res = countCommas(n);
        System.out.println(res);
    }

    private static int countCommas(int n) {
        String s = n+"";
        int len = s.length();
        if(len<=3)return 0;
        else return n-1000+1;
    }
}
