package com.com.leetcode.feb;

public class BinaryGap {
    public static void main(String[] args) {
        int n = 8;
        int res = binaryGap(n);
        System.out.println(res);
    }

    private static int binaryGap(int n) {
        int maxGap = 0;
        String bin = Integer.toBinaryString(n);
        int i =0;
        int j =0;
        while(j<bin.length()){
            if(bin.charAt(j)=='1'){
                maxGap = Math.max(maxGap,j-i);
                i=j;
            }
            j++;
        }
        return maxGap;
    }
}
