package com.com.leetcode.july;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SmallestSubsequenceofDistinctCharacters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String res = smallestSubsequence(s);
        System.out.println(res);
    }

    private static String smallestSubsequence(String s) {
        int n = s.length();
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();
        //prepossing last index of each character
        for(int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(visited[ch - 'a']) continue;
            while(!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
