package com.com.leetcode.march;

import java.util.Arrays;

public class FindAllPossibleStableBinaryArraysII {

    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int zero = 3, one = 3, limit = 2;
        int count = numberOfStableArrays(zero, one, limit);
        System.out.println(count);
    }

    private static int numberOfStableArrays(int zero, int one, int limit) {
        int [][][] dp = new int[zero+1][one+1][2];
        for(int i=1;i<=Math.min(zero, limit);i++){
            dp[i][0][0] =1;
        }
        for(int i=1;i<=Math.min(one, limit);i++){
            dp[0][i][1] =1;
        }
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                if(i==0 || j==0)continue;
                //ends with 1
                dp[i][j][1] = (dp[i][j-1][1]+dp[i][j-1][0])%MOD;
                if(j-1 >=limit)
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-1-limit][0]+MOD)%MOD;

                dp[i][j][0] = (dp[i-1][j][0]+dp[i-1][j][1])%MOD;
                if(i-1 >=limit)
                    dp[i][j][0] = (dp[i][j][0] - dp[i-1-limit][j][1]+MOD)%MOD;
            }
        }
        int c1 = dp[zero][one][0];
        int c2 = dp[zero][one][1];

        return (c1+c2)%MOD;
    }

//    private static int numberOfStableArrays(int zero, int one, int limit) {
//        int [][][] t = new int[1001][1001][2];
//        for(int [][] a:t){
//            for(int [] b:a){
//                Arrays.fill(b,-1);
//            }
//        }
//        int startWithOne = solve(zero, one, limit, 1, t);
//        int startWithZero = solve(zero, one, limit, 0,t);
//        return (startWithOne+startWithZero)%MOD;
//    }
//
//    private static int solve(int zeroLeft, int oneLeft, int limit, int isOne, int [][][] t) {
//        //base condition
//        if(zeroLeft==0 && oneLeft==0)return 1;
//        int count =0;
//        if(t[zeroLeft][oneLeft][isOne] != -1) return t[zeroLeft][oneLeft][isOne];
//        if(isOne==1){
//            for(int i=1;i<=Math.min(limit, zeroLeft);i++){
//                count = (count+solve(zeroLeft-i,oneLeft,limit,0,t));
//            }
//        }else{
//            for(int i=1;i<=Math.min(oneLeft,limit);i++){
//                count =(count+solve(zeroLeft, oneLeft-i,limit,1,t));
//            }
//        }
//        return t[zeroLeft][oneLeft][isOne] =count;
//    }
}
