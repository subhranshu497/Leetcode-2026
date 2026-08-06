package com.com.leetcode.august;

public class SmallestDivisibleDigitProductI {
    public static void main(String[] args) {
        int n =15;
        int t = 3;
        int res = smallestNumber(n,t);
        System.out.println(res);
    }

    private static int smallestNumber(int n, int t) {
        int res =0;
        //first
        for(;n<=100;n++){
            int num =n;
            res = num;
            int prod =1;
            while(num>0){
                int rem = num%10;
                prod *=rem;
                num /=10;
            }
            if(prod%t==0)return res;
        }
        return res;
    }
}
