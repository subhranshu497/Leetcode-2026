package com.com.leetcode.august;

public class LexicographicallySmallestPermutationGreaterThanTarget {
    public static void main(String[] args) {
        String s = "abc";
        String target = "bba";
        String res = lexGreaterPermutation(s, target);
        System.out.println(res);
    }
    public static String lexGreaterPermutation(String s, String target) {
        char [] count = new char[26];
        for(char c:s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = lexGreaterPermutationSolve(count, s, target, sb, 0, false);
        return flag==true?sb.toString():"";
    }
    private static boolean lexGreaterPermutationSolve(char[] count, String s, String target, StringBuilder sb, int i, boolean greater) {
        if(i==target.length()){
            if(greater){
                return true;
            }else return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(count[ch-'a']==0)continue;
            if(!greater && ch<target.charAt(i))continue;
            boolean isGreater = greater || ch>target.charAt(i);
            sb.append(ch);
            count[ch-'a']--;
            if(lexGreaterPermutationSolve(count, s, target, sb, i+1, isGreater)) return true;
            sb.deleteCharAt(sb.length()-1);
            count[ch-'a']++;
        }
        return false;
    }
}
