package com.com.leetcode.march;

public class CheckIfBinaryStringHasatMostOneSegmentofOnes {
    public static void main(String[] args) {
        String s = "1001";
        boolean result = checkOnesSegment(s);
        System.out.println(result);
    }

    private static boolean checkOnesSegment(String s) {
        int n = s.length();
        if(n==1 && s.charAt(0)=='1')return true;
        int count =0;
        int i=0;
        while(i<n){
            int j =i;
            while(j<n && s.charAt(j)=='1'){
                j++;
            }
            if(i !=j){
                count++;
            }
            i=j+1;
        }
        return count==1;
    }
}
