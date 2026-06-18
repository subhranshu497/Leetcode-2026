package com.com.leetcode.june;

public class ProcessStringwithSpecialOperationsI {
    public static void main(String[] args) {
        String s = "a#b%*";
        String res = processStringI(s);
        System.out.println(res);
    }

    private static String processStringI(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            //check if the character is an alphabe
            if(Character.isAlphabetic(ch)) sb.append(ch);
            else if(ch == '#') sb = sb.append(sb);
            else if(ch == '%') sb = sb.reverse();
            else if(ch == '*'){
                if(sb.length()>0)
                    sb = sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}
