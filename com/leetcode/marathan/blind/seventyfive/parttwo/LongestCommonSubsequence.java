package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;
import java.util.Map;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int len = longestCommonSubsequence(text1, text2);
        System.out.println(len);
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] t = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }

//    private static int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        int [][] memo = new int[m+1][n+1];
//        for(int [] arr:memo)
//            Arrays.fill(arr,-1);
//        return lcsSolve(text1,text2,m,n,0,0, memo);
//    }
//
//    private static int lcsSolve(String text1, String text2, int m, int n, int i, int j, int [][] memo) {
//        //base case
//        if(i>=m || j>=n) return 0;
//        int takeBoth = 0;
//        if(memo[i][j] != -1)return memo[i][j];
//        if(text1.charAt(i)==text2.charAt(j)){
//            takeBoth =1+lcsSolve(text1,text2,m,n,i+1,j+1,memo);
//        }else{
//            int takeI = lcsSolve(text1,text2,m,n,i+1,j, memo);
//            int takeJ = lcsSolve(text1,text2,m,n,i,j+1,memo);
//            takeBoth= Math.max(takeI, takeJ);
//        }
//        return memo[i][j]=takeBoth;
//    }
}
