package com.com.leetcode.may;

import java.util.Set;

public class RotatedDigits {
    public static void main(String[] args) {
        int n = 857;
        int res = rotatedDigits(n);
        System.out.println(res);
    }

    private static int rotatedDigits(int n) {
        int count =0;
        for(int i=1;i<=n;i++){
            String s = String.valueOf(i);
            if(s.contains("2")||s.contains("5")|| s.contains("6")|| s.contains("9")){
                if(s.contains("3")||s.contains("4")|| s.contains("7")) continue;
                else count++;
            }
        }
        return count;
    }
}
