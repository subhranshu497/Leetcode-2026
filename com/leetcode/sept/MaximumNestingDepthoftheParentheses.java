package com.com.leetcode.sept;

import java.util.Stack;

public class MaximumNestingDepthoftheParentheses {
    public static void main(String[] args) {
        String s = "()(())((()()))";
        int maxDepth = maxDepthII(s);
        System.out.println(maxDepth);
    }

    private static int maxDepthII(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(char ch:s.toCharArray()){
            if(ch=='(')st.push(ch);
            else if(ch==')')st.pop();
            int size = st.size();
            res = Math.max(size, res);
        }
        return res;
    }
}
