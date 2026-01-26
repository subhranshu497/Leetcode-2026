package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class PalindromicSubstrings {
    private static int count =0;
    public static void main(String[] args) {
        String s = "aaa";
        int subStringCount = countSubstrings(s);
        System.out.println(subStringCount);
    }

    private static int countSubstrings(String s) {
        int len = s.length();
        for(int i = 0;i<len;i++){
            //for odd length str
            checkPalli(s, i,i,len);
            checkPalli(s,i,i+1,len);
        }
        return count;
    }

    private static void checkPalli(String s, int start, int end, int len) {
        while(start>=0 && end < len && s.charAt(start) == s.charAt(end)){
            count +=1;
            start--;
            end++;
        }
    }

}
