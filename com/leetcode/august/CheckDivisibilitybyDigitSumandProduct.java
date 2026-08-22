package com.com.leetcode.august;

public class CheckDivisibilitybyDigitSumandProduct {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(checkDivisibility(n));
    }

    private static boolean checkDivisibility(int n) {
        int sum =0;
        int prod =1;
        int n_ =n;
        while(n !=0){
            int rem =n%10;
            sum +=rem;
            prod *=rem;
            n /=10;
        }
        return n_%(sum+prod)==0;
    }
}
