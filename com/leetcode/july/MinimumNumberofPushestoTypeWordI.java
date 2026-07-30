package com.com.leetcode.july;

public class MinimumNumberofPushestoTypeWordI {
    public static void main(String[] args) {
        String word = "abcde";
        int len = minimumPushes(word);
        System.out.println(len);
    }

    private static int minimumPushes(String word) {
        int n = word.length();
        int mod = n%8;
        int ans =0;
        int res = n/8;
        int i=1;
        for(;i<=res;i++){
            int prod = i*8;
            ans +=prod;
        }
        int fprod = i*mod;
        ans +=fprod;
        return ans;
    }
}
