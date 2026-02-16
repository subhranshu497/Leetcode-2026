package com.com.leetcode.feb;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        int res = reverseBits(n);
        System.out.println(res);
    }

    private static int reverseBits(int n) {
        int res = 0;
        if(n==0)return res;
        for(int i =1;i<=32;i++){
            //make room for upcoming bits
            res = res << 1;
            //to get the lsb from the num
            int bit = n&1;
            res = res|bit;
             n = n>>1;
        }
        return res;
    }
}
