package com.com.leetcode.august;

import java.util.Arrays;

public class StoneGameIII {
    private static int [] t;
    public static void main(String[] args) {
        int [] stoneValue ={1,2,3,7};
        String res = stoneGameIII(stoneValue);
        System.out.println(res);
    }

    private static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        if(n==1){
            if(stoneValue[0]<0) return "Bob";
            else if (stoneValue[0]>0) return "Alice";
            else return "Tie";
        }
        int [] dp = new int[n+1];
        dp[n-1] = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
            dp[i] = stoneValue[i] - dp[i + 1];
            if (i + 2 <= n) {
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
            }
            if (i + 3 <= n) {
                dp[i] = Math.max(dp[i],stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
            }
        }
        if(dp[0]==0) return "Tie";
        else if(dp[0]>0) return "Alice";
        else return "Bob";
    }

//    private static String stoneGameIII(int[] stoneValue) {
//        int n = stoneValue.length;
//        t = new int[n+1];
//        Arrays.fill(t,-1);
//        if(n==1){
//            if(stoneValue[0]<0) return "Bob";
//            else if (stoneValue[0]>0) return "Alice";
//            else return "Tie";
//        }
//        int val = stoneGameIIIRecursion(stoneValue, n,0);
//        if(val==0) return "Tie";
//        else if(val>0) return "Alice";
//        else return "Bob";
//    }
//
//    private static int stoneGameIIIRecursion(int[] stoneValue, int n, int i) {
//
//        if(i>=n)return 0;
//        if(t[i] !=-1)return t[i];
//        int firstmove = stoneValue[i]-stoneGameIIIRecursion(stoneValue,n,i+1);
//        int max= firstmove;
//        max = Math.max(max, firstmove);
//        if(i+1 <n){
//            int secondMove = stoneValue[i]+stoneValue[i+1]-stoneGameIIIRecursion(stoneValue,n,i+2);
//            max = Math.max(max, secondMove);
//        }
//        if(i+2 < n){
//            int thirdMove = stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-stoneGameIIIRecursion(stoneValue,n,i+3);
//            max = Math.max(max, thirdMove);
//        }
//        return t[i]=max;
//    }
}
