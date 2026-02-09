package com.com.leetcode.feb;

public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        String s = "bbaaaaabb";
        int del = minimumDeletions(s);
        System.out.println(del);
    }

    private static int minimumDeletions(String s) {
        int bCount =0;
        int del=0;
        for (char ch:s.toCharArray()){
            if(ch=='a'){
                if(bCount>0){
                    del++;
                    bCount--;
                }
            }else bCount++;
        }
        return del;
    }
}
