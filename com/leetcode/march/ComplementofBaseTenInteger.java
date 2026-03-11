package com.com.leetcode.march;

public class ComplementofBaseTenInteger {
    public static void main(String[] args) {
        int n = 5;
        int res = bitwiseComplement(n);
        System.out.println(res);
    }

    private static int bitwiseComplement(int n) {
        if(n==0) return 1;
        //find the number of bits
        int bitCount = (int)(Math.log(n)/Math.log(2))+1;
        //create the mask of n with the bitcount
        int mask = (1<<bitCount)-1;
        //to flip the bit
        return n^mask;
    }
}
