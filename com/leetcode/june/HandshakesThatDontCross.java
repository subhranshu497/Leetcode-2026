package com.com.leetcode.june;

import java.util.Arrays;

public class HandshakesThatDontCross {
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int numPeople =6;
        int res = numberOfWays(numPeople);
        System.out.println(res);
    }

    private static int numberOfWays(int numPeople) {
        int pairs = numPeople/2;
        int [] memo = new int[pairs+1];
        Arrays.fill(memo,-1);
        return solveNumberOfWays(pairs, memo);
    }

    private static int solveNumberOfWays(int pairs, int[] memo) {
        if(pairs <=1)return 1;
        if(memo[pairs] != -1)return memo[pairs];
        int res = 0;
        for(int pair=0;pair<pairs;pair++){
            int leftPairs = pair;
            int rightPairs = pairs-1-pair;
            int left = solveNumberOfWays(leftPairs, memo);
            int right = solveNumberOfWays(rightPairs, memo);
            int sum = (int)(((long)left*right)%MOD);
            res = (res+sum)%MOD;
        }
            return memo[pairs] = res;
    }

}
