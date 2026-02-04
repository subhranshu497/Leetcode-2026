package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        String res = gcdOfStrings(str1, str2);
        System.out.println(res);
    }

    private static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))return "";
        int len1 = str1.length();
        int len2 = str2.length();
        int end = gcdHelper(len1,len2);
        String res = "";
        if(len1>len2) res = str1.substring(0, end);
        else res = str2.substring(0,end);

        return res;
    }

    private static int gcdHelper(int num1, int num2) {
        //base case
        if(num2==0)return num1;
        return gcdHelper(num2, num1%num2);
    }
}
