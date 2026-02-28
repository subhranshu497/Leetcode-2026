package com.com.leetcode.feb;

public class ConcatenationofConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        int n = 12;
        int res = concatenatedBinary(n);
        System.out.println(res);
    }

    private static int concatenatedBinary(int n) {
        long res =0;
        for(int i=1;i<=n;i++){
            // find the number of bits in the current number
            int digits= 32 - Integer.numberOfLeadingZeros(i);
            //now to make space for the upcoming digits
            //do a left shift of the current result by digit times
            res = res << digits;
            //now add the current number to the result
            res = (res | i)% 1000000007;
        }
        //convert the result to decimal
        return (int)res;
    }
}
