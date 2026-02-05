package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class ReverseWordsinaString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String res =reverseWords(s);
        System.out.println(res);
    }

    private static String reverseWords(String s) {
        s.trim();
        String [] strArr = s.split("\\s+");
        int len = strArr.length;
        StringBuilder sb = new StringBuilder();
        for(int i=len-1;i>=0;i--){
            sb.append(strArr[i]);
            if(i !=0) sb.append(" ");
        }
        return sb.toString();
    }
}
