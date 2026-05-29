package com.com.leetcode.may;

public class ConfusingNumber {
    public static void main(String[] args) {
        int n = 80;
        boolean result = confusingNumber(n);
        System.out.println(result);
    }

    private static boolean confusingNumber(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        if(str.length()==1 && (n==0 || n==1 || n==8)) return false;
        if(str.indexOf('2') != -1||str.indexOf('3') != -1||str.indexOf('4') != -1||str.indexOf('5') != -1||str.indexOf('7') != -1) return false;
        int sum =0;
        int temp =n;
        while(n>0){
            int rem = n % 10;
            int rotatedDigit = rem;
            if(rem == 6) rotatedDigit = 9;
            else if(rem == 9) rotatedDigit = 6;
            sum = sum * 10 + rotatedDigit;
            n /=10;
        }
        return sum != temp;
    }
}
