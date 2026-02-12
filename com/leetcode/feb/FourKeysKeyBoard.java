package com.com.leetcode.feb;

public class FourKeysKeyBoard {
    public static void main(String[] args) {
        int n = 7;
        int count = maxA(n);
        System.out.println(count);
    }

    public static int maxA(int n) {
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<=5)dp[i] =i;
            else {
                //type A
                int typeA = dp[i-1]+1;
                //int 3steps back
                int threeStepsBack = dp[i-3]*2;
                int fourStepsBack = dp[i-4]*3;
                int fiveStepsBack = dp[i-5]*4;
                dp[i] = Math.max(typeA,threeStepsBack);
                dp[i] = Math.max(dp[i],fourStepsBack);
                dp[i] = Math.max(dp[i],fiveStepsBack);
            }
        }
        return dp[n];
    }
}
