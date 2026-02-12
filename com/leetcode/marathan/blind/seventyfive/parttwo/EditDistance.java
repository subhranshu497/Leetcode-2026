package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int min = minDistance(word1, word2);
        System.out.println(min);
    }

    private static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] memo = new int[m+1][n+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        return minDistSolve(word1, word2,m,n,0,0, memo);
    }

    private static int minDistSolve(String word1, String word2, int m, int n, int i, int j, int[][] memo) {
        //base case
        if(i==m)return n-j;
        if(j==n) return m-i;
        if(memo[i][j] != -1) return memo[i][j];
        int min =0;
        if(word1.charAt(i)==word2.charAt(j))
            min= minDistSolve(word1,word2,m,n,i+1,j+1,memo);
        else{
            int insert = 1+minDistSolve(word1,word2,m,n,i+1,j,memo);
            int delete = 1+minDistSolve(word1,word2,m,n,i,j+1, memo);
            int replace = 1+minDistSolve(word1,word2,m,n,i+1,j+1, memo);
            min = Math.min(insert, Math.min(delete,replace));
        }
        return memo[i][j] = min;
    }
}
