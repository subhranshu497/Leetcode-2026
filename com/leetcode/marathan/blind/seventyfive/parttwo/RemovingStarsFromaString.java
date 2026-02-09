package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Stack;

public class RemovingStarsFromaString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        String res = removeStars(s);
        System.out.println(res);
    }

    private static String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch-'a'>=0 && ch-'a'<26){
                st.push(ch);
            }
            else st.pop();
        }
        if(st.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
