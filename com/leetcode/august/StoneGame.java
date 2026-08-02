package com.com.leetcode.august;

import java.util.Arrays;

public class StoneGame {
    private static int [][] t;
    public static void main(String[] args) {
        int [] piles = {3,7,2,3};
        boolean res = stoneGame(piles);
        System.out.println(res);
    }

    private static boolean stoneGame(int[] piles) {
        int n = piles.length;
        t = new int[n+1][n+1];
        for(int [] tArr:t){
            Arrays.fill(tArr, -1);
        }
        int scores = stoneGameResursion(piles,n,0,n-1);
        return scores>=0;
    }

    private static int stoneGameResursion(int[] piles, int n, int i, int j) {
        //base case
        if(i==j)return piles[i];
        if(t[i][j] != -1) return t[i][j];
        int moveRight = piles[i]-stoneGameResursion(piles, n,i+1,j);
        int moveLeft = piles[j]-stoneGameResursion(piles,n,i,j-1);
        return t[i][j] = Math.max(moveLeft, moveRight);
    }
}
