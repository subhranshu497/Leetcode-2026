package com.com.leetcode.jan;

public class PlusOne {
    public static void main(String[] args) {
        int [] digits = {9};
        int [] res = plusOne(digits);
        for(int r:res){
            System.out.print(r+", ");
        }
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
       for(int i=n-1;i>=0;i--){
           if(digits[i]<9){
               digits[i]++;
               return digits;
           }
           digits[i] =0;
       }
       int [] res = new int[n+1];
       res[0] =1;
       return res;
    }
}
