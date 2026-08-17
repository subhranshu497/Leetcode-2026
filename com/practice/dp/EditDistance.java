package com.com.practice.dp;

import java.util.Arrays;

public class EditDistance {
    private static int [][] memo;
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int count = minDistanceIIDP(word1,word2);
        System.out.println(count);
    }

    private static int minDistanceIIDP(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][] dp = new int[len1+1][len2+1];
        //now lets derive the bottoms up solution
        //base case
        for(int j=0;j<=len2;j++) dp[len1][j] = len2-j;
        for(int i=0;i<=len1;i++) dp[i][len2] = len1-i;

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    int insert = 1+dp[i+1][j];
                    int delete = 1+dp[i][j+1];
                    int replace = 1+dp[i+1][j+1];
                    dp[i][j] = Math.min(insert, Math.min(delete,replace));
                }
            }
        }
        return dp[0][0];
    }

    private static int minDistanceII(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        memo = new int[len1][len2];
        for(int [] mem:memo){
            Arrays.fill(mem, -1);
        }
        return minDistSolveII(word1, word2, len1,len2,0,0);
    }

    private static int minDistSolveII(String word1, String word2, int len1, int len2, int i, int j) {
        //base case
        if(i==len1)return len2-j;
        if(j==len2) return len1-i;
        if(memo[i][j] !=-1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        if(word1.charAt(i)==word2.charAt(j)){
            min = minDistSolveII(word1,word2,len1,len2,i+1,j+1);
        }else{
            //i have three option
            int insert = 1+minDistSolveII(word1,word2,len1,len2,i+1,j);
            int delete = 1+minDistSolveII(word1,word2,len1,len2,i,j+1);
            int replace = 1+minDistSolveII(word1,word2,len1,len2,i+1,j+1);
            min = Math.min(delete, Math.min(insert,replace));
        }
        return memo[i][j]=min;
    }
}
