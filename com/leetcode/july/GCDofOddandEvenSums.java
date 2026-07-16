package com.com.leetcode.july;

public class GCDofOddandEvenSums {
    public static void main(String[] args) {
        int n =4;
        int sum = gcdOfOddEvenSums(n);
        System.out.println(sum);
    }

    private static int gcdOfOddEvenSums(int n) {
        int a = 0;
        int b = 0;
        for(int i=1;i<=2*n;i++){
            if(i%2==0){
                a+=i;
            }else{
                b+=i;
            }
        }
        return gcdOfOddEvenSumsSolve(a,b);
    }

    private static int gcdOfOddEvenSumsSolve(int a, int b) {
        if(b==0)return a;
        return gcdOfOddEvenSumsSolve(b,a%b);
    }
}
