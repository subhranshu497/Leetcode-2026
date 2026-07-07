package com.com.leetcode.july;

public class ConcatenateNonZeroDigitsandMultiplybySumI {
    public static void main(String[] args) {
        int n = 123405;
        long res = concatenateAndMultiply(n);
        System.out.println(res);
    }

    private static long concatenateAndMultiply(int n) {
        if(n==0)return 0;
        StringBuilder sb = new StringBuilder();
        long sum =0;
        while(n >0){
            int digit = n % 10;
            if(digit !=0){
                sb.append(digit);
            }
            sum += digit;
             n /= 10;
        }
        long concatenatedNumber = Long.parseLong(sb.reverse().toString());
        return concatenatedNumber * sum;
    }
}
