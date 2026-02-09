package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean flag = isSubsequence(s,t);
        System.out.println(flag);
    }

    private static boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int i=0;
        int j =0;
        while(i<sLen && j<tLen){
            char currCh = s.charAt(i);
            if(currCh==t.charAt(j))i++;
            j++;
        }
        return i==sLen;
    }
}

