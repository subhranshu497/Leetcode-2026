package com.com.leetcode.sept;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        String res = reverseParentheses(s);
        System.out.println(res);
    }

    private static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(sb.length());
            }else if(ch==')'){
                int start = st.pop();
                int end = sb.length();
                String sub = sb.substring(start, end);
                String  sb1 = new StringBuilder(sub).reverse().toString();
                sb.replace(start, end, sb1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
