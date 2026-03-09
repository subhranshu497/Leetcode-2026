package com.com.leetcode.march;

import java.util.Arrays;
import java.util.Map;

public class FindAllPossibleStableBinaryArraysI {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int zero = 2, one = 1;
        int limit = 2;
        int count = countGoodBinaryStrings(zero, one, limit);
        System.out.println(count);
    }

    private static int countGoodBinaryStrings(int zero, int one, int limit) {
        int[][][] t = new int[one + 1][zero + 1][2];

        // Base case: solve(0,0,lastWasOne) = 1
        t[0][0][0] = 1;
        t[0][0][1] = 1;

        for (int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for (int zerosLeft = 0; zerosLeft <= zero; zerosLeft++) {
                if (onesLeft == 0 && zerosLeft == 0) continue;

                // if(lastWasOne == true) { explore 0s }
                int result = 0;
                for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                    result = (result + t[onesLeft][zerosLeft - len][0]) % MOD;
                }
                t[onesLeft][zerosLeft][1] = result;

                // else { explore 1s }
                result = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    result = (result + t[onesLeft - len][zerosLeft][1]) % MOD;
                }
                t[onesLeft][zerosLeft][0] = result;
            }
        }

        int startWithOne  = t[one][zero][0]; // solve(one, zero, false, limit)
        int startWithZero = t[one][zero][1]; // solve(one, zero, true, limit)
        return (startWithOne + startWithZero) % MOD;
    }

//    private static int countGoodBinaryStrings(int zero, int one, int limit) {
//        int [][][] dp = new int[201][201][2];
//        for(int [][] a:dp){
//            for(int [] b:a){
//                Arrays.fill(b, -1);
//            }
//        }
//        int startWithOne = solve(zero, one, limit, 0, dp);
//        int startWithZero = solve(zero, one, limit, 1, dp);
//        return (startWithOne + startWithZero)%MOD;
//    }
//
//    private static int solve(int zeroLeft, int oneLeft, int limit, int lastOne, int [][][] dp) {
//        if(zeroLeft == 0 && oneLeft == 0) return 1;
//        if(dp[zeroLeft][oneLeft][lastOne] != -1) return dp[zeroLeft][oneLeft][lastOne];
//        int count = 0;
//        if(lastOne==1){
//            for(int i=1;i<=Math.min(limit, zeroLeft);i++){
//                count =(count + solve(zeroLeft-i, oneLeft, limit, 0, dp))%MOD;
//            }
//        }else{
//            for(int i=1;i<=Math.min(limit, oneLeft);i++){
//                count =(count+ solve(zeroLeft, oneLeft-i, limit, 1, dp))%MOD;
//            }
//        }
//        return dp[zeroLeft][oneLeft][lastOne] = count%MOD;
//    }
}
