package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        int ways = numDecodings(s);
        System.out.println(ways);
    }

    private static int numDecodings(String s) {
        int n = s.length();
        int [] t = new int[n+1];
        //dfine the state
        t[n] = 1; //since we reached till end , so there is one way
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0')t[i] = 0;
            else{
                t[i] = t[i+1];
                if(i+1<n && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')))
                    t[i] +=t[i+2];
            }
        }
        return t[0];
    }

//    private static int numDecodings(String s) {
//        int n = s.length();
//        int [] memo = new int[n+1];
//        Arrays.fill(memo ,-1);
//        return numDecodingsSolve(s,0,n, memo);
//    }
//
//    private static int numDecodingsSolve(String s, int i, int n, int [] memo) {
//        //base case
//        if(i==n) return 1;
//        if(i<n && s.charAt(i)-'0'==0)return 0;
//        if(memo[i] !=-1)return memo[i];
//        int result =0;
//        //option 1 - split by one char
//        result = numDecodingsSolve(s, i+1,n, memo);
//        if(i+1< n){
//            if(s.charAt(i)-'0'==1 || (s.charAt(i)-'0'==2 && s.charAt(i+1)-'0' <=6))
//                result += numDecodingsSolve(s,i+2,n, memo);
//        }
//
//
//        return memo[i]=result;
//    }
}
