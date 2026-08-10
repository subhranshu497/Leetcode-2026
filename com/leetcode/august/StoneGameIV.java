package com.com.leetcode.august;

public class StoneGameIV {
    public static void main(String[] args) {
        int n =6;
        boolean res = winnerSquareGame(n);
        System.out.println(res);
    }

    private static boolean winnerSquareGame(int n) {
         int MAX = 100000;
            boolean[] dp = new boolean[MAX+1];
            for(int i=0;i<=n;i++){
                if(!dp[i]){
                    for(int j=1;i+(j*j)<=n;j++){
                        dp[i+(j*j)] = true;
                    }
                    if(dp[n])return true;
                }
            }
            return false;
        }

}
