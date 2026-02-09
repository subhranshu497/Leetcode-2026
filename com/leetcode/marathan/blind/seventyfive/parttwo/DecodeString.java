package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String res = decodeString(s);
        System.out.println(res);
    }

    private static String decodeString(String s) {
        int n = s.length();
        Stack<Integer> countStack= new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int k =0;
        StringBuilder currStr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10 + (ch-'0');
            }else if(ch=='['){
                countStack.push(k);
                k=0;
                stringStack.push(currStr);
                currStr = new StringBuilder();
            }else if(ch==']'){
                int freq = countStack.pop();
                StringBuilder decodeStr = currStr;
                currStr = stringStack.pop();
                while(freq>0){
                    currStr.append(decodeStr);
                    freq--;
                }
            }
            else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
