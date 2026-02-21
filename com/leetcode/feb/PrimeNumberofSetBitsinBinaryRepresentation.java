package com.com.leetcode.feb;


public class PrimeNumberofSetBitsinBinaryRepresentation {
    public static void main(String[] args) {
        int left = 6;
        int right = 10;
        int res = countPrimeSetBits(left, right);
        System.out.println(res);
    }

    private static int countPrimeSetBits(int left, int right) {
        int count =0;
        for(int i=left;i<=right;i++){
            int setBits = Integer.bitCount(i);
            count += isPrime(setBits) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if(num<2)return false;
        for(int i=2;i<num;i++){
            if(num%i==0)return false;
        }
        return true;
    }

}
