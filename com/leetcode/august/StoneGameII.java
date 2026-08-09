package com.com.leetcode.august;

import java.util.Arrays;

public class StoneGameII {
    public static void main(String[] args) {
        int [] piles = {2,7,9,4,4};
        int res = stoneGameII(piles);
        System.out.println(res);
    }

    private static int stoneGameII(int[] piles) {
        int n = piles.length;
        int M = 1;
        int [] sffixSum = new int[n];
        sffixSum[n-1] = piles[n-1];
        for(int i=n-2;i>=0;i--){
            sffixSum[i] =sffixSum[i+1]+piles[i];
        }
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = stoneGameIIRecursion(piles, n, M,0, sffixSum, memo);
        return ans;
    }

    private static int stoneGameIIRecursion(int[] piles, int n, int M, int i, int [] sum, int [][] memo) {
        //base case
        if(i>=n)return 0;
        //optional base case - if player takes all remaining stones at one go
        if(n-i <= 2*M) return sum[i];
        if(memo[i][M] !=-1)return memo[i][M];
        int maxStone = 0;

        for(int x=1;x<=2*M;x++){
            int nextM = Math.max(M, x);
            //stones oppentent can get from index i+x
            int stonesBob = stoneGameIIRecursion(piles,n,nextM,i+x, sum, memo);
            //stones Alice can get = Total remaining from i - stones oppenet gets
            int stonesAlice = sum[i]-stonesBob;
            maxStone = Math.max(maxStone, stonesAlice);
        }
        return memo[i][M] =maxStone;
    }
}
