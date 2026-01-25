package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        boolean flag = isValidI(s);
        System.out.println(flag);
    }

    private static boolean isValidI(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch :s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[')st.push(ch);
            else if(ch==')'){
                char ch1 = st.peek();
                if(ch1 !='(') return false;
                else st.pop();
            }else if(ch=='}'){
                char ch1 = st.peek();
                if(ch1 !='{') return false;
                else st.pop();
            }else if(ch==']'){
                char ch1 = st.peek();
                if(ch1 !='[') return false;
                else st.pop();
            }
        }
        return st.isEmpty()?true:false;
    }
}
