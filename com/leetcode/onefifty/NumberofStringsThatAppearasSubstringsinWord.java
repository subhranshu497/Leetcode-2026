package com.com.leetcode.onefifty;

public class NumberofStringsThatAppearasSubstringsinWord {
    public static void main(String[] args) {
        String [] patterns = {"a","abc","bc","d"};
        String word = "abc";
        int res = numOfStrings(patterns, word);
        System.out.println(res);
    }

    private static int numOfStrings(String[] patterns, String word) {
        int count =0;
        for(String s:patterns){
            if(word.contains(s))count++;
        }
        return count;
    }
}
