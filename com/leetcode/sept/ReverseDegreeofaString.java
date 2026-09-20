package com.com.leetcode.sept;

public class ReverseDegreeofaString {
    public static void main(String[] args) {
        String s = "abc";
        int res = reverseDegree(s);
        System.out.println(res);
    }

    private static int reverseDegree(String s) {
        int i =1;
        int revdegree =0;
        for(char ch:s.toCharArray()){
            int pos = 26-(ch-'a');
            pos *=i;
            revdegree +=pos;
            i++;
        }
        return revdegree;
    }
}
